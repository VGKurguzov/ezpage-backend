package com.saxakiil.ezpage.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.saxakiil.TmaParser;
import com.saxakiil.ezpage.entity.User;
import com.saxakiil.ezpage.service.UserService;
import com.saxakiil.model.InitDataParsed;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class UserInterceptor implements HandlerInterceptor {

    private final UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws JsonProcessingException {
        InitDataParsed initDataParsed = TmaParser.parse(request.getHeader("Authorization").split(" ")[1]);
        Long id = initDataParsed.getUser().getId();
        User user = userService.findByTgId(id).orElseGet(() -> userService.create(id));
        request.setAttribute("user", user);
        return true;

    }
}
