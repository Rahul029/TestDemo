package com.mindtree.stepdefinition;

import com.mindtree.pageobject.Login;
import com.mindtree.reusable.ReusableMethod;
import com.mindtree.utility.BaseClass;
import com.mindtree.utility.Log;
import com.mindtree.utility.ProgressBar;
import com.mindtree.utility.Screenshot;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends BaseClass {

	@Given("^user navigates to home page$")
	public void user_navigates_to_home_page()  {
		ReusableMethod.loadUrl(driver, log);
		ReusableMethod.timelaps(driver);
		Screenshot.screenshot(driver);
		Log.logInfo(log, "usre navigated to home page");
		ProgressBar.setProgress();
	}

	@When("^I clicked on Login tab$")
	public void i_clicked_on_Login_tab()  {
		Login.loginTab(driver, log);
		Screenshot.screenshot(driver);
		Log.logInfo(log, "clicked on login tab");
	}

	@Then("^I am able to see the login page$")
	public void i_am_able_to_see_the_login_page()  {
		Login.loginPageTitle(driver, log);
		Screenshot.screenshot(driver);
		Log.logInfo(log, "login page is open");
	}

	@When("^I enter \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String arg1, String arg2, String arg3)  {
		Login.fillInfo(driver, log, arg1, arg2, arg3);
		Screenshot.screenshot(driver);
		Log.logInfo(log, "all information entered");
	}

	@And("^Clicked on login button$")
	public void clicked_on_login_button() throws Throwable {
		Login.loginButton(driver, log);
		Screenshot.screenshot(driver);
		Log.logInfo(log, "login button is clicked");
	}

	@Then("^I am able to see the home page of the Delta Application$")
	public void i_am_able_to_see_the_home_page_of_the_Delta_Application() {
		Login.validateHomePageTitle(driver, log);
		Screenshot.screenshot(driver);
		Log.logInfo(log, "home page opened");
	}
}
