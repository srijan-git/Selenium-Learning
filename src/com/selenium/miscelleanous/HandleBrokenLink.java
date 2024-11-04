package com.selenium.miscelleanous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class HandleBrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// Step 1 : Get all the urls tied up to the links
		// Step 2: Java method gets all the status code
		// Step 3: If status code is >400 then that url is not working

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		/*
		 * For Single Link
		 * 
		 * String url =
		 * driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		 * 
		 * HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		 * 
		 * conn.setRequestMethod("HEAD");
		 * 
		 * conn.connect();
		 * 
		 * int responseCode = conn.getResponseCode();
		 * 
		 * System.out.println(responseCode);
		 */

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		SoftAssert softAssert = new SoftAssert();

		for (WebElement link : links) {

			String url = link.getAttribute("href");

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("HEAD");

			conn.connect();

			int responseCode = conn.getResponseCode();

			System.out.println(responseCode);

			/*
			 * Soft assert
			 */
			softAssert.assertTrue(responseCode < 400,
					"The link with text " + link.getText() + " is broken with code " + responseCode);

			/*
			 * Hard assertion
			 * 
			 * if (responseCode > 400) {
			 * 
			 * System.out.println("The link with text " + link.getText() +
			 * " is broken with code " + responseCode);
			 * 
			 * Assert.assertTrue(false);
			 * 
			 * }
			 */
		}

		softAssert.assertAll();
	}

}
