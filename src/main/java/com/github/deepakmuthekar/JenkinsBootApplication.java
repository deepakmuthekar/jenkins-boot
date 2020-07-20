package com.github.deepakmuthekar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsBootApplication.class, args);
	}

	@GetMapping("/demo")
	public String demo() {
		return "Jenkins Sonarqube";
	}
}
