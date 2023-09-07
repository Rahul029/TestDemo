package com.mindtree.uistore;

import org.openqa.selenium.By;

public class SearchUI {

	//from field
	public static By from = By.id("fromAirportName");
	
	//to field
	public static By to = By.id("toAirportName");
	
	//search input
	public static By searchInput = By.id("search_input");
	
	//list of items
	public static By listitem = By.xpath("//div[@class='search-result-container']//li");
	
	//date 
	public static By dateInput = By.id("input_departureDate_1");
	
	//date of bound
	public static By dateOutbound = By.xpath("//a[@aria-label='14 June 2021, Monday']");
	
	//date of return 
	public static By dateReturn = By.xpath("//a[@aria-label='18 June 2021, Friday']");
	
	//done buton calendar
	public static By done = By.xpath("//button[@class='donebutton']");
	
	//search button
	public static By search = By.id("btn-book-submit");
}
