package com.meteo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.ParseException;
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

		User user1 = new User((long) 1, "TotoDu62", "","", "fr", selections);

		Selection selection3 = new Selection((long) 3, "Troisième", "Paris", "", "");

		user1.addSelection(selection3);

		System.out.println(user1.getSelectionLength());
		JSONObject firstTest = OpenWeatherApi.getDataFromCity(user1.getOwnSelection().get(2).getCityName(), user1.getLang());

		// get an array of value
		JSONArray weather = (JSONArray) firstTest.get("weather");
		// get an object value
		JSONObject weatherData = (JSONObject) weather.get(0);

		System.out.println(weatherData.get("description"));

		// get basic value
		System.out.println(firstTest.get("name"));

		JSONObject secondTest  = OpenWeatherApi.getDataFromPos(30.489772, -99.771335, user1.getLang());

		JSONArray weather2 = (JSONArray) secondTest.get("weather");
		JSONObject weatherData2 = (JSONObject) weather2.get(0);

		System.out.println(weatherData2.get("description"));

		System.out.println(secondTest.get("name"));
	}

}
