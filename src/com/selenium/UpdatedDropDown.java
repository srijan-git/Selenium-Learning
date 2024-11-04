package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropDown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		// Open the passengers list
		driver.findElement(By.id("divpaxinfo")).click();

		// Whatever value is showing in Passenger dropdown
		/*
		 * String optionValueString = driver.findElement(By.id("spanAudlt")).getText();
		 * 
		 * System.out.println(optionValueString);
		 * 
		 * int count = Integer.parseInt(optionValueString);
		 * 
		 * int desiredCountForAdult = 4;
		 * 
		 * int actualCount = count - desiredCountForAdult;
		 * actualCount = Math.abs(actualCount);
		 */
		
		

		for (int i = 0; i < 5; i++) {
			// Get the plus button
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		// Click on done button
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
