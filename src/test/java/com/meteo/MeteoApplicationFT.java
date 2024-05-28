package com.meteo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class MeteoApplicationFT {
    /**
     * @param args
     */
    public static void main(String[] args) {

// objects and variables instantiation
        WebDriver driver = new FirefoxDriver();
        String appUrl = "http://localhost:4200";

// launch the firefox browser and open the application url
        driver.get(appUrl);

// maximize the browser window
        driver.manage().window().maximize();

        WebElement connectionButton = driver.findElement(By.id("connectionButton"));
        connectionButton.click();

        // click on the Sign in button
        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys("Tozano");

        WebElement profileButton = driver.findElement(By.id("profileButton"));
        profileButton.click();

        WebElement addButton = driver.findElement(By.id("addButton"));
        addButton.click();

        WebElement surname = driver.findElement(By.id("surname"));
        surname.clear();
        surname.sendKeys("Test");

        WebElement cityName = driver.findElement(By.id("cityName"));
        cityName.clear();
        cityName.sendKeys("Paris");

        WebElement createPlaceButton = driver.findElement(By.id("createPlaceButton"));
        createPlaceButton.click();

        WebElement test = driver.findElement(By.id("Test"));

        // close the web browser
        driver.close();
        System.out.println("Test script executed successfully.");

        // terminate the program
        System.exit(0);
    }
}
