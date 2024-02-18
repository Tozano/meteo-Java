package com.meteo;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class OpenWeatherApi {
    public static JSONObject getDataFromCity(String cityName, String langage) {
        JSONObject datasToSend = new JSONObject();
        try {
            String API_KEY = "e770987537502ea5e63dd4234268b7a2";
            String API_URL = "http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&lang="+langage+"&APPID="+API_KEY;

            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResonseCode: " +responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                scanner.close();

                JSONParser parse = new JSONParser();
                datasToSend = (JSONObject) parse.parse(inline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return datasToSend;
    }

    public static JSONObject getDataFromPos(double lat, double lon, String langage) {
        JSONObject datasToSend = new JSONObject();
        try {
            String API_KEY = "e770987537502ea5e63dd4234268b7a2";
            String API_URL = "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&lang="+langage+"&APPID="+API_KEY;

            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResonseCode: " +responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                scanner.close();

                JSONParser parse = new JSONParser();
                datasToSend = (JSONObject) parse.parse(inline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return  datasToSend;
    }
}
