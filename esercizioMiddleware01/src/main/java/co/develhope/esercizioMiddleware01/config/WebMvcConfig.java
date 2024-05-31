package co.develhope.esercizioMiddleware01.config;

import co.develhope.esercizioMiddleware01.interceptors.APILoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig {

    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(apiLoggingInterceptor);
            }
        };
    }
}