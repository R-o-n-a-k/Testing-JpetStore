package stepDefination;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Search;
import utility.ExcelReader;
import utility.Initialize;
import utility.ScreenshotGenerator;

//@Test
public class Tc1_ValidSearchProduct extends Initialize {
  
  public static Search search;
	public static boolean result;
	public static String productName;
	public static String actResult;
	
	public Tc1_ValidSearchProduct() {
		super();
	}
	
	@Given("the user is in the homepage")
	public void the_user_is_in_the_homepage() throws IOException {
		search = new Search(driver);

//		Getting the website link
		search.getSite();
	}
	
	@When("he enters product name in search bar from {string} and {int}")
	public void he_enters_product_name_in_search_bar_from_and(String SheetName, Integer int1)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
//		Getting the data from excel sheet 
		List<Map<String, String>> testData = reader
				.getData("C:\\CAPGEMINI\\Training\\Module 4\\Selenium demo\\testingSprint\\TestingSprint.xls", SheetName);
		productName = testData.get(int1).get("searchProduct");
		Initialize.report.startTest(productName);
		
		jse.executeScript("window.scrollBy(0,300)");
//		Searching the product and storing the url in actResult
		actResult = search.searchProduct(productName);

		jse.executeScript("window.scrollBy(0,300)");
	}
	
	@Then("user should be able to see the details of the item entered")
	public void user_should_be_able_to_see_the_details_of_the_item_entered() throws InterruptedException, IOException {

		String expResult = "https://jpetstore.aspectran.com/catalog/searchProducts?keyword=" + productName;
		
//		Comparing the expResult and actResult using assert
		assertEquals(actResult,expResult);
		Initialize.report.getResult(actResult,expResult);
		Initialize.report.endTest();
		
//		closing the browser
		driver.quit();
	}

	
	
}
