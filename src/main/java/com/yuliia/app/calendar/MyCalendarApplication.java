package com.yuliia.app.calendar;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.mvc.Controller;

import com.yuliia.app.calendar.config.JwtConfig;

@SpringBootApplication
public class MyCalendarApplication {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(MyCalendarApplication.class, args);
        
        // Правильный способ вывода контроллеров:
        System.out.println("\n=== Все контроллеры ===");
        ctx.getBeansOfType(Object.class).forEach((name, bean) -> {
            if (bean.getClass().isAnnotationPresent(org.springframework.stereotype.Controller.class) || 
                bean.getClass().isAnnotationPresent(org.springframework.web.bind.annotation.RestController.class)) {
                System.out.println(name + " : " + bean.getClass());
            }
        });
    }

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
