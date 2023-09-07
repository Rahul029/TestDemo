package com.mindtree.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.mindtree.utility.PropertyFileReader;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"Features"}, glue= {"com.mindtree.stepdefinition"}, 
plugin= {"com.cucumber.listener.ExtentCucumberFormatter:Extent_Report/cucumber-reports/report.html"},
   tags= {"@Login, @SearchFlight"}, monochrome=true,dryRun=false)



public class Runner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(PropertyFileReader.loadFile().getProperty("reportConfigPath")));
	}
}
