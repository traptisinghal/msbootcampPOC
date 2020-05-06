package com.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MicroServSpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServSpringCloudConfigServerApplication.class, args);
	}

}
