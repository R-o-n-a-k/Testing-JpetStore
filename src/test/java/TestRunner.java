
//import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utility.Initialize;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//features", glue = { "stepDefination" },tags="@invalid",plugin = {
        "json:target/cucumber-report/cucumber.json",
        "html:target/cucumber-report/cucumber.html" })
public class TestRunner extends AbstractTestNGCucumberTests {
	@BeforeSuite
    public void beforeSuite() {
//		Initializing the report
      Initialize.reportInitialization();
      
//      Starting the report
      Initialize.report.startReport();
    }

   @AfterSuite
    public void afterSuite() {
//	   Closing the report
        Initialize.report.endReport();
    }
}


