package com.play.bob.global.config;

import com.play.bob.tokenverify.interceptor.AccessTokenVerifyIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author baobo.peng
 */
@Configuration
public class AccessTokenVerfyConfig extends WebMvcConfigurationSupport {

    @Bean
    public AccessTokenVerifyIntercepter accessTokenVerifyIntercepter() {
        return new AccessTokenVerifyIntercepter();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessTokenVerifyIntercepter()).addPathPatterns("/jpush/**");
        super.addInterceptors(registry);
    }
}
