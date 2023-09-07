package com.mindtree.stepdefinition;

import com.mindtree.pageobject.Search;
import com.mindtree.reusable.ReusableMethod;
import com.mindtree.utility.BaseClass;
import com.mindtree.utility.Log;
import com.mindtree.utility.ProgressBar;
import com.mindtree.utility.Screenshot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchFlightStepDefinition extends BaseClass {

	@Given("^user is navigates to home page$")
	public void user_is_navigates_to_home_page() {
		ReusableMethod.loadUrl(driver, log);
		Screenshot.screenshot(driver);
		Log.logInfo(log, "successfully navigated to home page");
		ProgressBar.setProgress();
	}

	@When("^user search for the flight in the Delta application$")
	public void user_search_for_the_flight_in_the_Delta_application() {
		Search.search(driver, log);
		Screenshot.screenshot(driver);
		Log.logInfo(log, "information filled successfully");
	}

	@When("^clicked on search button$")
	public void clicked_on_search_button() throws InterruptedException {
		Search.searchButton(driver, log);
		Screenshot.screenshot(driver);
		Log.logInfo(log, "search button cliked");
	}

	@Then("^user is able to see the book flight page$")
	public void user_is_able_to_see_the_book_flight_page() {
		Search.validateFlightPage(driver, log);
		Screenshot.screenshot(driver);
		Log.logInfo(log, "user is in book flight page now");
	}
}
