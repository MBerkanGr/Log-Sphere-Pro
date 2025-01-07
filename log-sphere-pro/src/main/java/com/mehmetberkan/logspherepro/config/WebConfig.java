package com.mehmetberkan.logspherepro.config;

import com.mehmetberkan.logspherepro.interceptor.RequestInfoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final RequestInfoInterceptor requestInfoInterceptor;

    public WebConfig(RequestInfoInterceptor requestInfoInterceptor) {
        this.requestInfoInterceptor = requestInfoInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInfoInterceptor).addPathPatterns("/**");
    }
}
