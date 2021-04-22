package com.demo.pageObjects;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

//import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	public static AndroidDriver<AndroidElement> capabilities(String s) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver;

// TODO Auto-generated method stub
		File appDir = new File("src");
		File app = new File(appDir, "ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "K_Emulator");
		
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); //if need to run on real mobile device.
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		cap.setCapability("appPackage", "io.appium.android.apis"); 
	    cap.setCapability("appActivity","ApiDemos");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		
		return driver;
	}

}
