package com.selenium.miscelleanous;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class HandlingWindowAndCookieScreenShot {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().deleteCookieNamed("sessionkey");

		// Click on any link
		// Validate it nagivate to login page

		driver.get("https://google.com");

		File srvFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(srvFile, new File("/home/srijan-kumar-khan/Documents/screenshot.png"));
	}

}
