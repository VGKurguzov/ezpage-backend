package com.saxakiil.ezpage.validator;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HexFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class TmaValidator {

    private static final String ALGORITHM = "HmacSHA256";
    private static final String SECRET = "WebAppData";
    private static final String STOP_WORD = "includedRecord";
    private static final List<String> EXCLUDE_PARAMS = List.of("hash");

    private static String hash;

    public static void validate(String initData, String token) throws InvalidKeyException,
            NoSuchAlgorithmException {
        if (initData == null || initData.isEmpty()) {
            throw new RuntimeException("InitData is null or empty");
        }
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Token is null or empty");
        }
        Map<String, String> map = splitQuery(initData);
        String transformedInitData = transformMap(map);
        byte[] signatureToken = generateHMAC256SignatureToken(token);
        if (!generateHMAC256SignatureInitData(signatureToken, transformedInitData).equals(hash)) {
            throw new RuntimeException("Auth fail");
        }
    }

    private static String transformMap(Map<String, String> map) {
        return map.entrySet().stream()
                .map(entry -> String.format("%s=%s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }

    private static byte[] generateHMAC256SignatureToken(String token) throws InvalidKeyException,
            NoSuchAlgorithmException {
        Mac hmacSHA256 = Mac.getInstance(ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        hmacSHA256.init(secretKeySpec);
        hmacSHA256.update(token.getBytes(StandardCharsets.UTF_8));
        return hmacSHA256.doFinal();
    }

    private static String generateHMAC256SignatureInitData(byte[] signatureToken, String transformedInitData)
            throws InvalidKeyException, NoSuchAlgorithmException {
        Mac hmacSHA256 = Mac.getInstance(ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(signatureToken, ALGORITHM);
        hmacSHA256.init(secretKeySpec);
        hmacSHA256.update(transformedInitData.getBytes(StandardCharsets.UTF_8));
        byte[] signatureBytes = hmacSHA256.doFinal();
        return HexFormat.of().formatHex(signatureBytes);
    }

    private static Map<String, String> splitQuery(String initData) {
        if (initData == null || initData.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<String, String> map = new LinkedHashMap<>();

        Arrays.stream(initData.split("&"))
                .map(TmaValidator::splitQueryParameter)
                .filter(entry -> !entry.getValue().equals(STOP_WORD))
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> map.put(entry.getKey(), entry.getValue()));
        return map;
    }

    private static Map.Entry<String, String> splitQueryParameter(String it) {
        final int idx = it.indexOf("=");
        final String key = idx > 0 ? it.substring(0, idx) : it;
        final String value = idx > 0 && it.length() > idx + 1 ? it.substring(idx + 1) : null;

        if (EXCLUDE_PARAMS.contains(key)) {
            if (value == null) {
                throw new RuntimeException("Hash is null");
            }
            hash = URLDecoder.decode(value, StandardCharsets.UTF_8);
            return Map.entry(URLDecoder.decode(key, StandardCharsets.UTF_8), STOP_WORD);
        }
        return Map.entry(URLDecoder.decode(key, StandardCharsets.UTF_8),
                value != null ? URLDecoder.decode(value, StandardCharsets.UTF_8) : STOP_WORD);
    }

}
