package com.saxakiil.ezpage.interceptor;

import com.saxakiil.ezpage.validator.TmaValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
@Log4j2
public class ValidateInterceptor implements HandlerInterceptor {

    @Value("${app.ezpage.telegram.secret}")
    private String telegramSecret;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String authorizationHeader = request.getHeader("Tma-Header");
        if (authorizationHeader == null || authorizationHeader.isEmpty()) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            log.error("Tma-Header header is empty or null");
            return false;
        }
        String[] authParams = authorizationHeader.split(" ");
        if (authParams.length < 2 || !authParams[0].equals("tma")) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            log.error("Incorrect authorization header: {}", authorizationHeader);
            return false;
        }
        try {
            TmaValidator.validate(authParams[1], telegramSecret);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return false;
        }
        return true;
    }
}
