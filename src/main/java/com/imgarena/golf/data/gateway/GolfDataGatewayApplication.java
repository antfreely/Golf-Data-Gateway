package com.imgarena.golf.data.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * Main application class.
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class GolfDataGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GolfDataGatewayApplication.class, args);
	}

}
