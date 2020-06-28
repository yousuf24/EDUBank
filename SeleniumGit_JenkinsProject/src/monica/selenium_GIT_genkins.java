package monica;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class selenium_GIT_genkins {
	WebDriver driver;

	@Test
	public void f() {
		driver.get("https://www.amazon.in/");
		if(driver.findElement(By.id("glow-ingress-line1")).isDisplayed()) {
			System.out.println("successfully opened");
		}
		else {
			System.out.println("AUT is not opened");
		}
	}

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\moham\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		  driver.manage().window().maximize();
	}

	@AfterSuite
	public void afterSuite() {

		driver.quit();
	}
}
