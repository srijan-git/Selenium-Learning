package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWebsiteAlert {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Srijan");

		driver.findElement(By.id("alertbtn")).click();

		System.out.println(driver.switchTo().alert().getText());

		// Handle Alerts
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Srijan");

		driver.findElement(By.id("confirmbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		
		//If alert box has two button "Ok" and "Cancel"
		driver.switchTo().alert().dismiss();
	}

}
