package com.selenium.scroll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlePageAndComponentScrolling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll inside the whole window
		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(5000L);

		// Scroll inside the component
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

	}

}
