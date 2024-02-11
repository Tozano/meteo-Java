package com.meteo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MeteoApplication {

	public static void main(String[] args) {
		Selection selection1 = new Selection((long) 1, "Premier");
		Selection selection2 = new Selection((long) 2, "Deuxième");

		List<Selection> selections = new ArrayList<>();
		selections.add(selection1);
		selections.add(selection2);

		User user1 = new User((long) 1, "TotoDu62", "","",selections);

		Selection selection3 = new Selection((long) 3, "Troisième");

		user1.addSelection(selection3);

		System.out.println(user1.getSelectionLength());
		//SpringApplication.run(MeteoApplication.class, args);
	}

}
