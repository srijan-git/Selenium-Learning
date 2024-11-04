package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDownPractice {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// This method will only be applicable if there is select tag
		// ==================================================================================================
		// Dropdown with select tag
		WebElement staticDropDownElement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(staticDropDownElement);

		// Drop down option will be selected by index
		dropdown.selectByIndex(3);

		// First element from the drop down will be selected
		System.out.println(dropdown.getFirstSelectedOption().getText());

		// Select drop down option based on the Text visible
		dropdown.selectByVisibleText("AED");

		// Select drop down option based on the value attribute
		dropdown.selectByValue("INR");
		// ====================================================================================================
	}
}
