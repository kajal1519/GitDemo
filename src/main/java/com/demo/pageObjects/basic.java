package com.demo.pageObjects;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basic extends base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver= capabilities("emulator"); //choose either real device or emulator by changing attribute value.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		//driver.findElement(By.id("android:id/button1")).click();
		PopUpPage pu=new PopUpPage(driver);
		pu.countinueButton.click();
		
		//driver.findElement(By.id("android:id/button1")).click();
		PopUpPage pu1=new PopUpPage(driver);
		pu1.okButton.click();
		
		HomePage h=new HomePage(driver);
		//now if u want to click/tap on preferences then no need to write like driver.findElement......
		//simply we need to write below code
		h.Preferences.click();
		
		
		Preferences p=new Preferences(driver);
		p.dependencies.click();
		
		dependencies d=new dependencies(driver);
		d.checkbox.click();
	}

}
