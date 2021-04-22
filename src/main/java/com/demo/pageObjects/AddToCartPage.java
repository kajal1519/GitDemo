package com.demo.pageObjects;


import java.io.ObjectInputStream.GetField;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddToCartPage {

	

	public AddToCartPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// driver.findElement(By.xpath("//*[@text='Argentina']")).click();
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	//public WebElement selectCountryName;  // we can use this way also but privacy is going to maintain here. so we make the member private.
	private WebElement selectCountryName;
	 
	 
	 
	 //driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement clickOnButton;
	
	
     
     //driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	private WebElement addToCart1;

	
     //driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	private WebElement addToCart2;

	
     //driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement button3 ;
	
	
	public WebElement selectCountryNameFromDropDown()
	{
		return selectCountryName;
	}

	public WebElement clickOnButton()
	{
		
		return clickOnButton;
	}
	
	public List<WebElement> clickOnAddToCartButton()
	{
		return (List<WebElement>) addToCart1;
		
	}
	
	public List<WebElement> clickOnAddToCartButtonAgain()
	{
		
		return (List<WebElement>) addToCart2;
	}
	
	public WebElement clickToButtonCart()
	{
		
		return button3;
	}
	
	
}
