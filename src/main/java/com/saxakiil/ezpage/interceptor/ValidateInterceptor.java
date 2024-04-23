package com.saxakiil.ezpage.interceptor;

import com.saxakiil.ezpage.validator.TmaValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class ValidateInterceptor implements HandlerInterceptor {

    @Value("${app.ezpage.telegram.secret}")
    private String telegramSecret;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null || authorizationHeader.isEmpty()) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        String[] authParams = authorizationHeader.split(" ");
        if (authParams.length < 2 || !authParams[0].equals("tma")) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
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
