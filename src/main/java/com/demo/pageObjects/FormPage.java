package com.demo.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	//constructor with argument
		public FormPage(AppiumDriver<AndroidElement> driver) 
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
			
			//this mean refering to own page. if it is other page then put page name as preferences
		}
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
		//public WebElement nameField;  // we can use this way also but privacy is going to maintain here. so we make the member private.
		private WebElement nameField;
		
		
		// driver.findElement(By.xpath("//*[@text='Female']")).click();
		@AndroidFindBy(xpath="//*[@text='Female']")
		public WebElement femaleOption;
		
		// driver.findElement(By.id("android:id/text1")).click();
		@AndroidFindBy(id="android:id/text1")
		private WebElement countrySelection;
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(text(\\\"Argentina\\\"));")
		public WebElement countryDropDown;
		
	
		
		
		public WebElement getNameField()
		{
			System.out.println("Trying to find the Name Field");
			return nameField;
		}
		
		public WebElement getCountrySelection()
		{
			System.out.println("Selecting the option from drop down");
			return countrySelection;
		}
		
		
		
}
