package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleCalenderUI {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		driver.findElement(By.xpath("//a[@value='BLR']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).click();

		// Click on Round Trip button
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();

		// After clicking on round trip what is the attribute
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		// Click on One way trip
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();

		// After clicking on One trip what is the attribute
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		//If it contains 1 that means it enabled and 0.5 means disabled
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Its Enabled");
		} else {
			System.out.println("Its Disabled");
		}

	}

}
