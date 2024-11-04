package com.selenium.openlink;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleSeparateTabs {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		for (int i = 0; i < driver.findElements(By.cssSelector("div[id='gf-BIG'] a")).size(); i++) {

			String clickOnLinkTabString = Keys.chord(Keys.CONTROL, Keys.ENTER);

			driver.findElements(By.cssSelector("div[id='gf-BIG'] a")).get(i).sendKeys(clickOnLinkTabString);

			Thread.sleep(5000L);

		}
	}

}
