package com.mindtree.reusable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mindtree.utility.PropertyFileReader;



public class ReusableMethod {


	public static boolean loadUrl(WebDriver driver, Logger log) {
		try {
			driver.get(PropertyFileReader.loadFile().getProperty("url"));
			log.info("website loaded");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String setDateTime() {
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("YYYY_MM_dd_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		return dateTime.format(now);
	}

	public static void timelaps(WebDriver driver) {
		int time = Integer.parseInt(PropertyFileReader.loadFile().getProperty("wait"));
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	public static boolean getElement(WebDriver driver, Logger log, By selector) {
		try {
			driver.findElement(selector);
			log.debug("Selector " + selector + "  found");
			return true;
		} catch (Exception e) {
			log.error("Selector " + selector + " not found");
			System.out.println("Selector " + selector + " not found");
		}
		return false;
	}

	public static boolean click(WebDriver driver, Logger log, By selector) {
		try {
			driver.findElement(selector).click();
			log.debug("Selector " + selector + "  Clicked");
			return true;
		} catch (Exception e) {
			log.error("Selector " + selector + " not clickable");
			System.out.println(e.getMessage());
			System.out.println("Error while clicking selector " + selector);
		}
		return false;
	}

	public static boolean sendKey(WebDriver driver, By searchBox, String string) {
		try {
			driver.findElement(searchBox).sendKeys(string);
			return true;
		} catch (Exception e) {
			System.out.println("Unable to enter data to the search box");

		}
		return false;

	}

	public static boolean sendKeysWithEnter(By selector, String value, WebDriver driver) {

		try {
			WebElement ele = driver.findElement(selector);
			ele.sendKeys(value);
			ele.sendKeys(Keys.ENTER);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean moveCursor(WebDriver driver, By selector) {
		Actions actions = new Actions(driver);
		try {
			actions.moveToElement(driver.findElement(selector)).build().perform();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean hover(By selector, WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(selector);
		try {
			action.moveToElement(ele).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean explicitWait(WebDriver driver, By selector) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		return true;
	}
	
	
	
	public static boolean jsClick(WebDriver driver, Logger log, By selector) {
		WebElement element = driver.findElement(selector);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		return true;
	}
}
