package com.saxakiil.ezpage.validator;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saxakiil.ezpage.validator.model.InitDataParsed;
import org.apache.commons.lang3.StringUtils;

public final class TmaParser {

    public static InitDataParsed parse(String initData) throws JsonProcessingException {
        String decodeInitData = URLDecoder.decode(initData, StandardCharsets.UTF_8);
        List<String> json = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(decodeInitData, "&");
        while (tokenizer.hasMoreElements()) {
            String line = tokenizer.nextToken();
            String[] splitLine = line.split("=");
            if (StringUtils.isNumeric(splitLine[1]) || line.contains("{")) {
                json.add(String.format("\"%s\":%s", splitLine[0], splitLine[1]));
            } else {
                json.add(String.format("\"%s\":\"%s\"", splitLine[0], splitLine[1]));
            }
        }
        String value = json.stream()
                .collect(Collectors.joining(","));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        return objectMapper.readValue("{" + value + "}", InitDataParsed.class);
    }
}
