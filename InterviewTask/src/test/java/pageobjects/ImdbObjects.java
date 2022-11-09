package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImdbObjects {

	@FindBy(xpath = "//input[@id=\"suggestion-search\"]")
	public static  WebElement search;
	
	@FindBy(xpath = "//a[normalize-space()='December 17, 2021 (United States)']")
	public static WebElement realseDateImdb;
	
	
	@FindBy(xpath = "//a[normalize-space()='India']")
	public static WebElement countryImdb;
	
	
	@FindBy(xpath = "//a[normalize-space()='Pushpa: The Rise - Part 1']")
	public static WebElement movieClick; 

}

