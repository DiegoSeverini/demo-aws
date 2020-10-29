package com.sequoia.demoaws;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;

@SpringBootApplication(exclude = {ContextInstanceDataAutoConfiguration.class})
public class DemoAwsApplication {

	@SneakyThrows
	public static void main(String[] args) {
		SpringApplication.run(DemoAwsApplication.class, args);
	}

}

