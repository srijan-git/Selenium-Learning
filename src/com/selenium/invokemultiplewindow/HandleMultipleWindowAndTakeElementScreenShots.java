package com.selenium.invokemultiplewindow;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleWindowAndTakeElementScreenShots {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();

		String firstWindow = it.next();

		String secondWindow = it.next();

		driver.switchTo().window(secondWindow);

		driver.get("https://rahulshettyacademy.com");

		String courseNameString = driver
				.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();

		driver.switchTo().window(firstWindow);

		WebElement nameFieldElement = driver.findElement(By.cssSelector("[name='name']"));

		nameFieldElement.sendKeys(courseNameString);

		File file = nameFieldElement.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("webelementscreenshot.png"));

		System.out.println("Height of the Input box: " + nameFieldElement.getRect().getDimension().getHeight());

		System.out.println("Width of the Input box: " + nameFieldElement.getRect().getDimension().getWidth());

		driver.quit();
	}

}
