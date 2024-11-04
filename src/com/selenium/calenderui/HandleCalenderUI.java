package com.selenium.calenderui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleCalenderUI {

	public static void main(String[] args) {

		String monthNumber = "6";

		String date = "15";

		String desiredYearString = "2027";

		String[] expectedLiStrings = { monthNumber, date, desiredYearString };

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();

		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

		driver.findElement(By.xpath("//button[text()='" + desiredYearString + "']")).click();

		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
				.get(Integer.parseInt(monthNumber) - 1).click();

		driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

		List<WebElement> actualElements = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

		for (int i = 0; i < actualElements.size(); i++) {

			System.out.println(actualElements.get(i).getAttribute("value"));

			Assert.assertEquals(actualElements.get(i).getAttribute("value"), expectedLiStrings[i]);
		}

		driver.close();
	}
}
