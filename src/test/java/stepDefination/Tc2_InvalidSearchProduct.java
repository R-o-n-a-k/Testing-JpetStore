package stepDefination;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Search;
import utility.Initialize;
import utility.ScreenshotGenerator;

//@Test
public class Tc2_InvalidSearchProduct extends Initialize {
	public static Search inSearch;
	public static int actResult;

	public Tc2_InvalidSearchProduct() {
		super();
	}
	@Given("the user is in homepage")
	public void the_user_is_in_homepage() throws IOException {
		inSearch = new Search(driver);
		
        ScreenshotGenerator.takeScreenshot(driver);
//		Getting the website link
		inSearch.getSite();
	}

	@When("he enters {string} name in search bar")
	public void he_enters_name_in_search_bar(String product) throws IOException {
		
//		Getting the invalid search product from feature file with parameters 
//		Storing the number of rows of table displayed in actResult  
		jse.executeScript("window.scrollBy(0,300)");
	   
		actResult=inSearch.inSearchProduct(product);
		jse.executeScript("window.scrollBy(0,300)");
	   Initialize.report.startTest(product);
	}

	@Then("user will not be able to see the details of the item entered")
	public void user_will_not_be_able_to_see_the_details_of_the_item_entered() {
	    int expResult=1;
	    
//	    Comparing the actResult with the expResult which is 1 as there are no products displayed
	    assertEquals(actResult,expResult);
		Initialize.report.getResult(actResult,expResult);
		Initialize.report.endTest();
		driver.quit();
	}

}
