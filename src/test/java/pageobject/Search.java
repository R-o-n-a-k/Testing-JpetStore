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

public class Search {

	public static Properties properties = new Properties();
	public static FileInputStream objfile;
	public WebDriver driver;

	public Search(WebDriver driver) throws FileNotFoundException {
		this.driver = driver;
		this.objfile = new FileInputStream(
				"C:\\CAPGEMINI\\Training\\Module 4\\Selenium demo\\jpetstore\\src\\test\\resources\\obj.properties");
	}
	public void getSite() throws IOException {
		driver.get("https://jpetstore.aspectran.com/catalog/");
		ScreenshotGenerator.takeScreenshot(driver);
	}
	
	public String searchProduct(String product) throws IOException {
		properties.load(objfile);
		WebElement searchElement=driver.findElement(By.xpath(properties.getProperty("searchElement")));
		
//		Sending the product from excel sheet to search bar
		searchElement.sendKeys(product);
		
//		Take Screenshot
		ScreenshotGenerator.takeScreenshot(driver);
		searchElement.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ScreenshotGenerator.takeScreenshot(driver);
		
//		Return the url after landing on searched product page
		return driver.getCurrentUrl();
	}
	
	public int inSearchProduct(String product) throws IOException {
		properties.load(objfile);
		WebElement searchElement=driver.findElement(By.xpath(properties.getProperty("searchElement")));
		
//		Sending the invalid product from feature file to search bar
		searchElement.sendKeys(product);
//		Take Screenshot
		ScreenshotGenerator.takeScreenshot(driver);
		searchElement.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ScreenshotGenerator.takeScreenshot(driver);
		List<WebElement> rows = driver.findElements(By.xpath("//tr"));
//		Getting the number of rows displayed on that page
		return rows.size();
	}
	
	

	
}
