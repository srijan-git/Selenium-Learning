package com.selenium.wait;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartItems {

	public static void main(String[] args) {

		String[] itemsNeeded = { "Brocolli", "Cucumber", "Beetroot", "Carrot" };

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		addItems(driver, itemsNeeded);
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {

		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		// Only select Cucumber
		/*
		 * for (int i = 0; i < products.size(); i++) { String name =
		 * products.get(i).getText();
		 * 
		 * if (name.contains("Cucumber")) {
		 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(
		 * ); break; } }
		 */

		// Select multiple product
		for (int i = 0; i < products.size(); i++) {

			// If we get Broccoli - 1KG then Broccoli will get extracted and Stored
			String veggieName = products.get(i).getText().split("-")[0].trim();

			List<String> veggiesNeeded = Arrays.asList(itemsNeeded);

			if (veggiesNeeded.contains(veggieName)) {
				j++;

				/*
				 * This will cause issue because When we click on ADD TO CART button the button
				 * text got changed to ADDED so it will not parse the right index
				 * 
				 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(
				 * );
				 */

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}

}
