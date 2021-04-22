package com.demo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PopUpPage {
	
	
	
	public PopUpPage(AppiumDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		//this mean refering to own page. if it is other page then put page name as preferences
	}
	
	
	


	//driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
	@AndroidFindBy(id="com.android.permissioncontroller:id/continue_button")
	public WebElement countinueButton;
	

	//driver.findElement(By.id("android:id/button1")).click();
	@AndroidFindBy(id="android:id/button1")
	public WebElement okButton;
	
	
	
	public WebElement clickCountinueButton()
	{
		System.out.println("Trying to find the Name Field");
		return countinueButton;
	}
	
	public WebElement clickOkButton()
	{
		System.out.println("Trying to find the Name Field");
		return okButton;
	}
	
}
