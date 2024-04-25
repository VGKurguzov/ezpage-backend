package com.saxakiil.ezpage.configuration;

import java.util.List;

import com.saxakiil.ezpage.interceptor.UserInterceptor;
import com.saxakiil.ezpage.interceptor.ValidateInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
                .order(0);
        registry.addInterceptor(userInterceptor)
                .excludePathPatterns(EXCLUDE_PATH_PATTERNS)
                .order(1);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
