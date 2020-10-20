package com.LoginTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Common.BaseClass;

public class LoginTC_2 extends BaseClass {
  @Test(description="login with valid Email and pass")
  public void login() throws IOException {
	  driver.get("https://demo.opencart.com/index.php?route=account/login");
	  WebElement Email = driver.findElement(By.id("input-email"));
		WebElement Password = driver.findElement(By.name("password"));
		WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

		String ExcptPostCond = " My Account22"; 
		Email.sendKeys("mail22@mail.com");
		Password.sendKeys("123456");
		LoginBtn.click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String ActualText1= driver.getTitle();
		
		if(ExcptPostCond.equals(ActualText1))
		{
			captureScreen(driver,"LoginTC_2");
			System.out.println("Test Case passed");
		}
		else {
			captureScreen(driver,"LoginTC_2_BUG");
			System.out.println("Failed");
		}
	  
  }
}
