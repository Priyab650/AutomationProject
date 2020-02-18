package org.test.selenium;

import org.testng.annotations.Test;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class FaceBookTest {
	public String baseUrl = "https://www.facebook.com/";
	public String loginURL=baseUrl+ "login";
   
    public WebDriver driver ; 
  @BeforeTest
  public void setDriver() {
	  String driverPath = "C:\\chromedriver.exe";
      System.setProperty("webdriver.chrome.driver", driverPath);
      driver = new ChromeDriver();
      driver.get(loginURL);
  }
   @Test
   public void verifyLogin()
   {
	   String userName="";
	   String password="";
	   java.util.Scanner input= new Scanner(System.in);
	   System.out.print("Enter the user name:");
	   userName=input.next();
	   System.out.print("Enter the password:");
	   password=input.next();
      WebElement us=driver.findElement(By.id("email"));
      us.sendKeys(userName);
      
      WebElement pw=driver.findElement(By.id("pass"));
      
      pw.sendKeys(password);
      
      WebElement btn=driver.findElement(By.id("loginbutton"));
      btn.click();
      System.out.println("asdadd title "+driver.getCurrentUrl());
      
      Assert.assertEquals(baseUrl, driver.getCurrentUrl());
      System.out.println("Hello World");
     
  }
   @AfterTest
   public void verifySuccess(ITestContext result) {
	   try {
		   driver.close();
		   
	   }catch(Exception e) {
		   System.out.println("@AfterTest failed ");
		   e.printStackTrace();
	   }
	   
		   
	   }	   
	     
}
