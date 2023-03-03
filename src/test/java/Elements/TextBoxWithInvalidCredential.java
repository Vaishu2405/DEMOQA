package Elements;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxWithInvalidCredential {

	WebDriver driver;
	Properties prop = new Properties();

	@Test
	public void verifyTextBox() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath(prop.getProperty("elements"))).click();
		driver.findElement(By.xpath(prop.getProperty("textbox"))).click();
		WebElement FullName = driver.findElement(By.xpath(prop.getProperty("fullname")));
		FullName.sendKeys(prop.getProperty("name"));
		WebElement Email = driver.findElement(By.xpath(prop.getProperty("email")));
		Email.sendKeys(prop.getProperty("invalidmail"));
		WebElement CurrentAddress = driver.findElement(By.xpath(prop.getProperty("currentAddress")));
		CurrentAddress.sendKeys(prop.getProperty("address"));
		WebElement permanentAddress = driver.findElement(By.xpath(prop.getProperty("permanentAddress")));
		permanentAddress.sendKeys(prop.getProperty("Address"));
		Thread.sleep(10000);
		WebElement Submit =  driver.findElement(By.xpath(" //button[@id='submit']"));
		js.executeScript("arguments[0].click();", Submit );
		
		
	}
	
	@BeforeTest
	public void baseTest() throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace1\\Project02_DEMOQA\\src\\main\\resources\\config.properties");
		prop.load(fis);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Dell\\eclipse-workspace1\\Project02_DEMOQA\\src\\main\\resources\\config.properties");
		prop.store(fos, null);
		
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
