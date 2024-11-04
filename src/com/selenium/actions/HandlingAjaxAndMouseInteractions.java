package com.selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingAjaxAndMouseInteractions {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();

		Actions actions = new Actions(driver);

		WebElement moveToSignInElement = driver
				.findElement(By.xpath("//a[@data-csa-c-slot-id='nav-link-accountList']"));

		WebElement inputbpxElement = driver.findElement(By.id("twotabsearchtextbox"));

		actions.moveToElement(moveToSignInElement).build().perform();

		actions.moveToElement(inputbpxElement).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build()
				.perform();

		actions.moveToElement(moveToSignInElement).contextClick().build().perform();
	}

}
