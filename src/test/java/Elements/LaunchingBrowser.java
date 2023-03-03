package Elements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingBrowser {
	WebDriver driver;
	Properties prop = new Properties();
	
	@Test
	public void browser() {
		String Expected_title = "DEMOQA";
		String Actual_title = driver.getTitle();
		Assert.assertEquals(Expected_title, Actual_title);
	}
	
	@BeforeTest
	public void baseTest() throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace1\\Project02_DEMOQA\\src\\main\\resources\\config.properties");
		prop.load(fis);
		WebDriverManager.chromedriver().setup();
	      driver = new ChromeDriver();
	    String url = prop.getProperty("url");
	    driver.get(url);
	     driver.manage().window().maximize();
		}
	
	@AfterMethod
	 public void afterMethod() {
		 driver.close();
	 }
}	
