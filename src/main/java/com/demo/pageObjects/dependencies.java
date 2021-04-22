package com.demo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//this is after clicking on preferences

public class dependencies {
	
	public dependencies(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		//this mean refering to own page. if it is other page then put page name as preferences
	}
	@AndroidFindBy(id="android:id/checkbox")
	public WebElement checkbox;
	

}
