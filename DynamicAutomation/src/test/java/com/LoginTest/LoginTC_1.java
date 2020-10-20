package com.LoginTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Common.BaseClass;

public class LoginTC_1 extends BaseClass {
  @Test(description="login with invalid Email")
  public void login() throws IOException {
	  driver.get("https://demo.opencart.com/index.php?route=account/login");
	  WebElement Email = driver.findElement(By.id("input-email"));
		WebElement Password = driver.findElement(By.name("password"));
		WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

		String ExcptPostCond = " Warning: No match for E-Mail Address and/or Password."; 
		Email.sendKeys("ratul@mail.com");
		Password.sendKeys("12846");
		LoginBtn.click();
		
		String ActualText1= driver.findElement(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible")).getText();
		
		if(ExcptPostCond.contains(ActualText1))
		{
			captureScreen(driver,"LoginTC_1");
			System.out.println("Test Case passed");
			
		}
		else {
			System.out.println("Failed");
		}
	  
  }
}
