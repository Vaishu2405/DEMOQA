package Elements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyAddWebTable {
	
	WebDriver driver;
	Properties prop = new Properties();
	
	
	@Test
	public void addData() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath(prop.getProperty("elements"))).click();
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath(prop.getProperty("WebTables"))).click();
		driver.findElement(By.xpath(prop.getProperty("Add"))).click();
		driver.findElement(By.xpath(prop.getProperty("FN"))).sendKeys(prop.getProperty("Fname"));
		driver.findElement(By.xpath(prop.getProperty("LN"))).sendKeys(prop.getProperty("Lname"));
		driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(prop.getProperty("mail"));
		driver.findElement(By.xpath(prop.getProperty("age"))).sendKeys(prop.getProperty("ag"));
		driver.findElement(By.xpath(prop.getProperty("salary"))).sendKeys(prop.getProperty("sl"));
		driver.findElement(By.xpath(prop.getProperty("department"))).sendKeys(prop.getProperty("dpt"));
		driver.findElement(By.xpath(prop.getProperty("btn"))).click();
		
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
