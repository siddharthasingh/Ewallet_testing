package test.java.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import test.java.Utils.SeleniumDriver;

public class TestLoginAddBeneficiaryTransferMoney extends SeleniumDriver {
	
  @Test
  public void execute() throws InterruptedException {
	  
	  String loginButton = "submit";
	  String userName = "firstname";
	  String password = "password";
	  String loginLink = "//*[@id='navigation']/ul/li[5]/a";
	  String addBeneficiaryLink = "//*[@id='first']/a[1]/h3";
	  String addBeneficiaryPage = "//*[@id='first']/form/legend/h1";
	  String mobileNumber = "mobile";
	  String frstName = "firstname";
	  String emailId = "email";
	  String signUpButton = "submit";
	  String transferMoney = "//*[@id='first']/h2/a";
	  
	  String transferMoneyPageHeader = "//*[@id='first']/form/h2";
	  String userMobileNumber = "mobile";
	  String beneficiaryName = "firstname";
	  String beneficiaryMobileNumber = "mobilenumber";
	  String amount = "amount";
	  String transferDetails = "transfer";
	  String submitTransfer = "submit";
	  String backNavigation = "//*[@id='first']/form/table/tbody/tr[6]/td[2]/a";
	  
	  WebElement login;
	  WebElement name;
	  WebElement pwd;
	  WebElement loginLinkNavigation;
	  
	  
	  //Waiting for the page to load
	  Thread.sleep(15000);
	  
	  WebDriver driver = SeleniumDriver.getDriver();
	  
	  try{
		  loginLinkNavigation = driver.findElement(By.xpath(loginLink));
		  loginLinkNavigation.click();
	  }catch(Exception e){
		  Assert.fail("The url has not loaded");
	  }
	  Reporter.log("Verified the navigation to Website");
	  
	  Thread.sleep(3000);
	  
	  login = driver.findElement(By.id(loginButton));
	  Assert.assertTrue(login.isDisplayed(), "The Login Page has not yet loaded");
	  Reporter.log("Verified the navigation to Login Page");
	  
	  name = driver.findElement(By.id(userName));
	  name.sendKeys("9093638884");
	  
	  pwd = driver.findElement(By.id(password));
	  pwd.sendKeys("password");
	  
	  login.click();
	  //waiting for page to load
	  Thread.sleep(3000);

	  driver.findElement(By.xpath(addBeneficiaryLink)).click();
	  
	  Thread.sleep(4000);
	  
	  Assert.assertTrue(driver.findElement(By.xpath(addBeneficiaryPage)).isDisplayed(), "The User has not navigated to add beneficairy page");
	  Reporter.log("The user has succesfully naviagted to the add beneficiary page");
	  
	  driver.findElement(By.id(mobileNumber)).sendKeys("8989206590");
	  
	  driver.findElement(By.id(frstName)).sendKeys("siddhartha");
	  
	  driver.findElement(By.id(emailId)).sendKeys("siddhartha.3@tcs.com");
	  
	  driver.findElement(By.id(signUpButton)).click();
	  
	  Thread.sleep(5000);
	  driver.findElement(By.xpath(transferMoney)).click();
	  
	  Assert.assertTrue(driver.findElement(By.xpath(transferMoneyPageHeader)).isDisplayed(), "User has not navigated to Transfer beneficiary Page");
	  Reporter.log("The user has navigated to Transfer money page");
	  
	  driver.findElement(By.id(userMobileNumber)).sendKeys("9093638884");
	  Thread.sleep(2000);
	  driver.findElement(By.id(beneficiaryName)).sendKeys("siddhartha");
	  Thread.sleep(2000);
	  driver.findElement(By.id(beneficiaryMobileNumber)).sendKeys("8989206590");
	  Thread.sleep(2000);
	  driver.findElement(By.id(amount)).sendKeys("10");
	  Thread.sleep(2000);
	  driver.findElement(By.id(transferDetails)).sendKeys("Demo");
	  Thread.sleep(2000);

	  
	//  driver.findElement(By.id(submitTransfer)).click();
  
  }
}
