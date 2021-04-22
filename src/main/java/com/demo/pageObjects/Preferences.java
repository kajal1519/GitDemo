package com.demo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//this is the one of the class after home page/screen
//preferences is one of the option/sub menu from the home screen.
//if we need to navigate to preferences sub-sub-menu then there will be one different class for that.
public class Preferences {

	
	public Preferences(AppiumDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		//this mean refering to own page. if it is other page then put page name as preferences
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement dependencies;
	
	
	//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

}
