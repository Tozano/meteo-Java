package com.meteo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeteoApplication {
	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(MeteoApplication.class, args);
		MeteoService meteoService = applicationContext.getBean(MeteoService.class);
			meteoService.getAndShowAllUsersWithSelections();
	}
}
