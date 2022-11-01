package stepDefination;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Validate;
import utility.Initialize;
import utility.ScreenshotGenerator;

//@Test
public class Tc3_ValidateProduct extends Initialize{
	public static Validate validate;
	
	public static int actResult;
	public Tc3_ValidateProduct() {
		super();
	}
	
	@Given("user is in the homepage")
	public void user_is_in_the_homepage() throws IOException {
		validate = new Validate(driver);
        ScreenshotGenerator.takeScreenshot(driver);
//		Getting the website link
		validate.getSite();
	}

	@When("he clicks fish on homepage")
	public void he_clicks_fish_on_homepage() throws IOException {
		Initialize.report.startTest ("Fish Validation");
		jse.executeScript("window.scrollBy(0,300)");
//		Clicking the fish link from homepage
		validate.clickFish();
		jse.executeScript("window.scrollBy(0,300)");
	}

	
	@Then("user will see the content of fish")
	public void user_will_see_the_content_of_fish() throws IOException {
		
//		Storing the total number of rows of data displayed after clicking fish
		actResult=validate.validateContent();
		
//		Total number of actual rows of data present in fish page
		int expResult=5;
		
//		Comparing actResult and expResult
	    assertEquals(actResult,expResult);
	    Initialize.report.getResult(actResult,expResult);
	    Initialize.report.endTest();
	    driver.quit();
	}
}
