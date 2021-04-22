package practice.AppiumFramework;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.pageObjects.HomePage;
import com.demo.pageObjects.PopUpPage;
import com.demo.pageObjects.Preferences;
import com.demo.pageObjects.dependencies;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;




@Test
public class ApiDemoTest extends base {

	@BeforeTest
	  public void killAllNodes() throws IOException,
	  InterruptedException { // taskkill /F /IM node.exe
	  Runtime.getRuntime().exec("taskkill /F /IM node.exe"); Thread.sleep(3000);
	  
	  }
	
	public ApiDemoTest() throws NullPointerException, IOException, InterruptedException
	{
		
		service=startServer();
		AndroidDriver<AndroidElement> driver= capabilities("apiDemo"); //choose either real device or emulator by changing attribute value.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
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
		
		
		
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		//stop and clean the appium service
		service.stop();
	
	}

}
