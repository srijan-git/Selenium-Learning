package com.selenium.actions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.cssSelector(".blinkingText")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> iterator = windows.iterator();

		String parentID = iterator.next();

		String childID = iterator.next();

		driver.switchTo().window(childID);

		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

		String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];

		System.out.println(emailID);

		driver.switchTo().window(parentID);

		driver.findElement(By.id("username")).sendKeys(emailID);

	}

}
