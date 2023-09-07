package com.mindtree.reusable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mindtree.utility.PropertyFileReader;



public class ReusableComponent {
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", PropertyFileReader.loadFile().getProperty("chromeDriver"));	
		WebDriver driver = new ChromeDriver();
		//log.info("driver loaded");
		driver.manage().window().maximize();
		ReusableMethod.timelaps(driver);
		return driver;
		
	}
}
