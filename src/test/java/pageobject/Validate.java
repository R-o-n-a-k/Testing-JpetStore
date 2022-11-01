package pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ScreenshotGenerator;

public class Validate{
	public static Properties properties = new Properties();
	public static FileInputStream objfile;
	public WebDriver driver;
	
	
	public Validate(WebDriver driver) throws FileNotFoundException {
		this.driver = driver;
		this.objfile = new FileInputStream(
				"C:\\CAPGEMINI\\Training\\Module 4\\Selenium demo\\jpetstore\\src\\test\\resources\\obj.properties");
	}
	
	public void getSite() throws IOException {
		driver.get("https://jpetstore.aspectran.com/catalog/");
		ScreenshotGenerator.takeScreenshot(driver);	
	}
	
	public void clickFish() throws IOException {
		properties.load(objfile);
		
//		Clicking the fish link
		driver.findElement(By.xpath(properties.getProperty("fish"))).click();
		ScreenshotGenerator.takeScreenshot(driver);
	}
	
	public int validateContent() throws IOException {
		properties.load(objfile);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ScreenshotGenerator.takeScreenshot(driver);
		
//		Getting the number of rows displayed
		List<WebElement> fishRows = driver.findElements(By.xpath("//tr"));
		return fishRows.size();
	}
}
