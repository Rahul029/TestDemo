package com.mindtree.uistore;

import org.openqa.selenium.By;

public class LoginUI {

	//login tab
	public static By Login = By.xpath("//button[@class='login-btn btn btn-danger']");
	
	//username field
	public static By userName = By.id("userId");
	
	//lastname field
	public static By lastName = By.id("lastName");
	
	//password filed
	public static By password = By.id("password");
	
	//login button
	public static By loginContinue = By.xpath("//button[@type='submit']");

}
