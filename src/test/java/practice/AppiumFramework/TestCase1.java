package practice.AppiumFramework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.pageObjects.AddToCartPage;
import com.demo.pageObjects.CheckOutPage;
import com.demo.pageObjects.FormPage;

import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestCase1 extends base{

	


	/*
	 * @BeforeTest public void killAllNodes() throws IOException,
	 * InterruptedException { // taskkill /F /IM node.exe
	 * Runtime.getRuntime().exec("taskkill /F /IM node.exe"); Thread.sleep(3000);
	 * 
	 * }
	 */
	
	
	
	
	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void totalValidation(String input) throws  IOException, InterruptedException
	{
		
		service=startServer();
		
		AndroidDriver<AndroidElement> driver=capabilities("GeneralStoreApp");		//this app name is general name its not exact apk name. we need to map the argument to actual application.

	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     FormPage formPage=new FormPage(driver);
	     
	     //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
	     formPage.getNameField().sendKeys(input);
	     driver.hideKeyboard();
	     // driver.findElement(By.xpath("//*[@text='Female']")).click();
	     formPage.femaleOption.click();
	     formPage.getCountrySelection().click();
	     //driver.findElement(By.id("android:id/text1")).click();
	     Utilities u=new Utilities(driver);
	     u.scrollToText("Argentina");
	     
	    // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
	     
	     AddToCartPage addToCartPage=new AddToCartPage(driver);
	     
	     //driver.findElement(By.xpath("//*[@text='Argentina']")).click();
	     addToCartPage.selectCountryNameFromDropDown().click();
	     
	     //driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	     addToCartPage.clickOnButton().click();
	     
	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	     //addToCartPage.clickOnAddToCartButton().get(0).click();

	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	     //addToCartPage.clickOnAddToCartButtonAgain().get(0).click();
	     
	     driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	     //addToCartPage.clickToButtonCart().click();

	Thread.sleep(4000);

	int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

	double sum=0;

	CheckOutPage checkOutPage=new CheckOutPage(driver);
	
	for(int i=0;i<count;i++)

	{

	String amount1= checkOutPage.productList.get(i).getText();

	double amount=getAmount(amount1);

	sum=sum+amount;//280.97+116.97

	}

	System.out.println("Sum of Products:" + sum);



	String total=checkOutPage.totalAmount.getText();



	total= total.substring(1);

	double totalValue=Double.parseDouble(total);

	System.out.println("Total value of products:" +totalValue);

	Assert.assertEquals(sum, totalValue); 

	
	service.stop();


	
	
	/*//Mobile Gestures

	WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));

	TouchAction t=new TouchAction(driver);

	t.tap(tapOptions().withElement(element(checkbox))).perform();



	WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));

	t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();

	driver.findElement(By.id("android:id/button1")).click();

	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();//navigate to web view

   */

	}

	public static double getAmount(String value)

	{

	value= value.substring(1);

	double amount2value=Double.parseDouble(value);

	return amount2value;

	}

	
}


