package com.mindtree.stepdefinition;

import org.apache.commons.mail.EmailException;

import com.mindtree.reusable.ReusableComponent;
import com.mindtree.utility.BaseClass;
import com.mindtree.utility.Email;
import com.mindtree.utility.Log;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks extends BaseClass{

	@Before
	public void beforeScenario() {
		driver = ReusableComponent.getDriver();
		log = Log.logger(LoginStepDefinition.class);
		log = Log.logger(SearchFlightStepDefinition.class);
		p.setVisible(true);
		Log.logMethod(log);
		
	}
	
	
	@After
	public void afterScenario() throws EmailException {
		driver.close();
		driver.quit();
		Email.sendEmail();
	}
}
