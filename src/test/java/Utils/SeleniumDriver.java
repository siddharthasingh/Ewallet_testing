package test.java.Utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class SeleniumDriver {

	public static WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "/tmp/chromedriver");
	        //WebDriver driver = new ChromeDriver();
		
		driver.get("http://ec2-52-36-155-174.us-west-2.compute.amazonaws.com:8086/Ewallet_devops-0.0.1/");
		System.out.println("Succesfully navigated");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) {
		if (testResult.getStatus() == 2) {
			try {
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy_MMM_dd_HH_mm");
				String passfailMethod = testResult.getMethod().getRealClass().getSimpleName();
				String destDir = "EWALLET"+dateFormat.format(new Date());
				// To capture screenshot. ScreenshotOnPassFail
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Set file name with combination of test class name + date
				// time.
				String destFile = "e-Wallet" + passfailMethod + " - " + dateFormat.format(new Date()) + ".png";

				// Store file at destination folder location
				FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
				System.out.println("Captured screen shot on failure");
			} catch (Exception e) {
				System.out.println(("afterMethod - Could not capture screenshot on failure"));
			}
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
