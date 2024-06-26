package com.saxakiil.ezpage.configuration;

import java.util.List;

import com.saxakiil.ezpage.interceptor.UserInterceptor;
import com.saxakiil.ezpage.interceptor.ValidateInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final static List<String> EXCLUDE_PATH_PATTERNS = List.of("/api/pages/{**}");

    private final ValidateInterceptor validateInterceptor;
    private final UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(validateInterceptor)
                .excludePathPatterns(EXCLUDE_PATH_PATTERNS)
                .addPathPatterns("/api/**")
                .order(0);
        registry.addInterceptor(userInterceptor)
                .excludePathPatterns(EXCLUDE_PATH_PATTERNS)
                .addPathPatterns("/api/**")
                .order(1);
    }
}
