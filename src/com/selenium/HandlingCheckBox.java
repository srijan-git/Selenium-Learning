package com.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		System.out.println("Check box selected or not: "
				+ driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		List<WebElement> checkBoxesElements = driver
				.findElements(By.xpath("//div[@id='discount-checkbox']//input[@type='checkbox']"));

		System.out.println("Number of checkboxes are: " + checkBoxesElements.size());
	}

}
