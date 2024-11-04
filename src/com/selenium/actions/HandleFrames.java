package com.selenium.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleFrames {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/droppable/");

		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

		driver.findElement(By.id("draggable")).click();

		Actions actions = new Actions(driver);

		WebElement sourElement = driver.findElement(By.id("draggable"));

		WebElement targetElement = driver.findElement(By.id("droppable"));

		actions.dragAndDrop(sourElement, targetElement).build().perform();

		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//div[@class='view-source']/a/i"))));

		driver.findElement(By.xpath("//div[@class='view-source']/a/i")).click();
	}

}
