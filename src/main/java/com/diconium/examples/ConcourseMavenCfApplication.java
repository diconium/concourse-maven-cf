package com.diconium.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class ConcourseMavenCfApplication {

	@RequestMapping
	public @ResponseBody String hello() {
		return "hello serenity world!";
	}

	public static void main(String[] args) {
		SpringApplication.run(ConcourseMavenCfApplication.class, args);
	}
}
