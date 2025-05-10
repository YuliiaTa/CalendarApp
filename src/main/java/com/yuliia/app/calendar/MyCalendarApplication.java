package com.yuliia.app.calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.yuliia.app.calendar.config.JwtConfig;

@SpringBootApplication
@EnableConfigurationProperties(JwtConfig.class)
public class MyCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCalendarApplication.class, args);
	}

}
