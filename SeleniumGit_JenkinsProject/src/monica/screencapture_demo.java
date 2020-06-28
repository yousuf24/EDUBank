package monica;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.*;


import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;

public class screencapture_demo {
	WebDriver driver;
	//rootLogger.addAppender(new NullAppender());
	ExtentReports reports = new ExtentReports("usr.dir"+"\\emailable-report.html");
	ExtentTest test =reports.startTest("EXTENT DEMO");
  @Test
  public void f() throws Exception {
	
	 
	  driver.get("https://www.amazon.in/");
	test.log(LogStatus.INFO, "AUT is opened successfully");
	//test.log(LogStatus.PASS,"AUT test is passed");
	test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+"test failed");
	  
	  
  }
  
  public String capture(WebDriver driver) throws Exception {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\moham\\Desktop\\"+System.currentTimeMillis()+".png");
		
		FileHandler.copy(srcFile, destFile);
		
	return destFile.getAbsolutePath() ;
	  
  }
  @BeforeSuite
  public void beforeSuite() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\moham\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @AfterSuite
  public void afterSuite() {
	  reports.endTest(test);
	  reports.flush();
	   
	  driver.quit();
  }

}
