package com.Common;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
	
	public static WebDriver driver;

  @Parameters("browser")
  @BeforeClass
  public void browser_Config(String br) {
	 // System.out.println(System.getProperty("user.dir"));
	 
	  
	  if(br.equals("firefox")) 
	  {
		  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe"); 
		  driver = new FirefoxDriver();
	  }
	  
	  else if(br.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();
		  
	  }
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
  }
  
  @AfterClass
  public void closeTest() {
	  
	  driver.quit();
  }
  
  @AfterTest
  public void captureScreen(WebDriver driver, String name) throws IOException {
	  
	 TakesScreenshot ts = (TakesScreenshot)driver;
	 
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 File target= new File(System.getProperty("user.dir")+ "/Screenshots/"+name+".png");
	 FileUtils.copyFile(source, target);
	 //System.out.println("Cap");
	  
  }
  
  
  
  
  
  
  
  
  
}
