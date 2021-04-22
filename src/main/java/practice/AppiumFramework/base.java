package practice.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	
	public static AppiumDriverLocalService service;

	static AndroidDriver<AndroidElement> driver;
	
	public AppiumDriverLocalService startServer()
	{		//link: https://github.com/appium/java-client/blob/master/src/test/java/io/appium/java_client/android/BaseAndroidTest.java
		
		boolean flag= checkIfServerIsRunning(4723);
		if(!flag)
		{
		service= AppiumDriverLocalService.buildDefaultService();   		//build start server is help us to start server 
		service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning= false;
		ServerSocket serverSocket;
		
		try
		{
			serverSocket=new ServerSocket(port);
			serverSocket.close();
			
		}
		catch(IOException e)
		{
			//if control comes here, then it means the port is in use
			isServerRunning= true;
			
		}
		finally
		{
			serverSocket=null;
			
		}
		return isServerRunning;
	}
	
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		//C:\Users\Kajal\eclipse-workspace\AppiumFramework\src\main\java\resource\startEmulator.bat
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\startEmulator.bat");
		Thread.sleep(6000);
	}
	
	
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException,NullPointerException, InterruptedException {
		
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practice\\AppiumFramework\\global.properties");    //from scr to global.properties is static path and works for every machine.
		Properties prop=new Properties();
		prop.load(fis);		//give file path i.e., global.properties
				//Retrieve the actual value of the application name
		prop.get("appName");
		
		//AndroidDriver<AndroidElement> driver;

// TODO Auto-generated method stub
		File appDir = new File("src");
		File app = new File(appDir,(String) prop.get(appName));
		DesiredCapabilities cap = new DesiredCapabilities();
		
		String device= (String) prop.get("device");				//device details
		if(device.toLowerCase().contains("emulator"))							//remember that emulator name should contain emulator keyword.
		{
			startEmulator();
		}
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);   //if u feel that system is slow
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); //if need to run on real mobile device.
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability("appPackage", "io.appium.android.apis"); 
	    cap.setCapability("appActivity","ApiDemos");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		return driver;
	}
	
	
	public static void getScreenshot(String s) throws IOException
	{
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		//tell the driver to change the mode to screen shot. so we need to cast it to "TakesScreenShot"
		FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\"+s+".png"));
				}
}
