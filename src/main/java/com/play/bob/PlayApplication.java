package com.play.bob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author baobo.peng
 */

@SpringBootApplication
@EnableAutoConfiguration
public class PlayApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PlayApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PlayApplication.class);
    }
}
