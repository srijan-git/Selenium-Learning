package com.selemium.windowhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowAuthentication {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// driver.get("https://the-internet.herokuapp.com/");

		driver.get("https://admin:admin@the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Basic Auth")).click();

	}

}
