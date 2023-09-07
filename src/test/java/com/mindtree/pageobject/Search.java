package com.mindtree.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.reusable.ReusableMethod;
import com.mindtree.uistore.SearchUI;
import com.mindtree.utility.PropertyFileReader;

public class Search {

	public static boolean search(WebDriver driver, Logger log) {
		if (ReusableMethod.click(driver, log, SearchUI.from))
			if (ReusableMethod.sendKey(driver, SearchUI.searchInput, "NYC")) {
				ReusableMethod.explicitWait(driver, SearchUI.listitem);
				if (ReusableMethod.sendKey(driver, SearchUI.searchInput, Keys.ARROW_DOWN + "" + Keys.ENTER)) {
					log.info("From location Entered");
					if (ReusableMethod.click(driver, log, SearchUI.to))
						if (ReusableMethod.sendKey(driver, SearchUI.searchInput, "BOM")) {
							ReusableMethod.explicitWait(driver, SearchUI.listitem);
							if (ReusableMethod.sendKey(driver, SearchUI.searchInput,
									Keys.ARROW_DOWN + "" + Keys.ENTER)) {
								log.info("To location Entered");
								if (ReusableMethod.click(driver, log, SearchUI.dateInput)) {
									ReusableMethod.click(driver, log, SearchUI.dateOutbound);
									ReusableMethod.click(driver, log, SearchUI.dateReturn);
									log.info("Departure and Return date selected");
									if (ReusableMethod.click(driver, log, SearchUI.done)) {
										return true;
									}
								}

							}

						}
				}
			}

		return false;
	}

	public static boolean searchButton(WebDriver driver, Logger log) throws InterruptedException {
		if (ReusableMethod.jsClick(driver, log, SearchUI.search)) {
			Thread.sleep(4000);
			log.info("search button clicked");
			return true;
			}
		return false;
	}

	public static boolean validateFlightPage(WebDriver driver, Logger log) {
		String title = driver.getTitle();
		Assert.assertEquals(title, PropertyFileReader.loadFile().getProperty("flightPageTitle"));
		return true;
	}

}
