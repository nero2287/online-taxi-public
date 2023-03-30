package com.taxi.passenger.intercepetor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public JWTInterceptor jwtInterceptor(){
        return new JWTInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                //拦截的路径
                .addPathPatterns("/**")
                //不拦截的路径
                .excludePathPatterns("/verification_code_check")
                .excludePathPatterns("/verification_code")
                .excludePathPatterns("/refresh_token")
                ;
    }
}
