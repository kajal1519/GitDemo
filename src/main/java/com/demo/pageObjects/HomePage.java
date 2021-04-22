package com.demo.pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//all the objects belonging to one page will be defined in one jave class
//means the number of modules defined under one screen needs to defined in one java class. if there are multiple screen then need separate java class file.
// also put the class name as module name for easy understanding n better practice
//every page have its own repository of objects

public class HomePage {
	// is to call the object from testcase to pageobject file
	//concatenate driver
	
	//constructor with argument
	public HomePage(AppiumDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		//this mean refering to own page. if it is other page then put page name as preferences
	}
	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement Preferences;
	
	
	/*what is above line mean= appium by default take above line as findElementByXpath("");
	 * this is same step.
	 * but in this case we r avoiding actual code.
	 * So basically preferences is we r giving name to above line.
	 * Preferences is variable.
	 */
	

}
