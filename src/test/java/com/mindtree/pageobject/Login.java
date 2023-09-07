package com.mindtree.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusable.ReusableMethod;
import com.mindtree.uistore.LoginUI;
import com.mindtree.utility.PropertyFileReader;
import org.testng.Assert;

public class Login {

	public static boolean loginTab(WebDriver driver, Logger log) {
		if (ReusableMethod.explicitWait(driver, LoginUI.Login))
			if (ReusableMethod.click(driver, log, LoginUI.Login)) {
				ReusableMethod.timelaps(driver);
				log.info("login tab is clicked");
				return true;
			}

		return false;
	}

	public static boolean fillInfo(WebDriver driver, Logger log, String username, String lastname, String password) {
		if (ReusableMethod.sendKey(driver, LoginUI.userName, username)) {
			log.info("username entered in the filed");
			if (ReusableMethod.sendKey(driver, LoginUI.lastName, lastname)) {
				log.info("lastname entered in the filed");
				if (ReusableMethod.sendKey(driver, LoginUI.password, password)) {
					log.info("password entered in the filed");
					return true;
				}
			}
		}
		return false;
	}

	public static boolean loginButton(WebDriver driver, Logger log) {
		if (ReusableMethod.explicitWait(driver, LoginUI.loginContinue))
			if (ReusableMethod.click(driver, log, LoginUI.loginContinue)) {
				log.info("login button cliked");
				return true;
			}
		return false;
	}

	
	public static boolean loginPageTitle(WebDriver driver, Logger log) {
		String title = driver.getTitle();
		Assert.assertEquals(title, PropertyFileReader.loadFile().getProperty("loginPageTitle"));
		return true;
	}
	
	
	public static boolean validateHomePageTitle(WebDriver driver, Logger log) {
		String title = driver.getTitle();
		Assert.assertEquals(title, PropertyFileReader.loadFile().getProperty("homePageTitle"));
		return true;
	}

}
