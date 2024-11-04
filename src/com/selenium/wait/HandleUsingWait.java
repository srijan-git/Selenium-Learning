package com.selenium.wait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleUsingWait {

	public static void main(String[] args) {

		String[] itemsNeeded = { "Brocolli", "Cucumber", "Beetroot", "Carrot" };

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		/*
		 * Implicit Wait : Applied to globally
		 * 
		 * driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		 * 
		 */

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		addItems(driver, itemsNeeded);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.cssSelector("button.promoBtn")).click();

		/*
		 * Explicit Wait : Applied only onto a specific element
		 * 
		 */

		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));

		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {

		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			String veggieName = products.get(i).getText().split("-")[0].trim();

			List<String> veggiesNeeded = Arrays.asList(itemsNeeded);

			if (veggiesNeeded.contains(veggieName)) {
				j++;

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}
}
