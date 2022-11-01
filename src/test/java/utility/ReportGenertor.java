package utility;

import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportGenertor {

	
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static int i = 1;

	public void startReport() {
		
//		Storing the extent reports in the location
		extent = new ExtentReports("C:\\CAPGEMINI\\Training\\Module 4\\Selenium demo\\jpetstore\\ExtentReport\\jpetstore.html",
				true);
	}

	public void startTest(String message) {
		logger = extent.startTest("Test 0"+ i +": "+message);
		i++;
	}

//	public void getResult(boolean acResult, boolean exResult) {
//		if (acResult == exResult) {
//			logger.log(LogStatus.PASS, "Test is pass");
//
//		} else {
//			logger.log(LogStatus.FAIL, "Test is failed");
//		}
//	}
	public void getResult(int acResult, int exResult) {
		if (acResult==exResult) {
			logger.log(LogStatus.PASS, "Test is pass");
		} else {
			logger.log(LogStatus.FAIL, "Test is failed");
		}
	}
	public void getResult(String acResult, String exResult) {
		if (acResult.equals(exResult)) {
			logger.log(LogStatus.PASS, "Test is pass");
		} else {
			logger.log(LogStatus.FAIL, "Test is failed");
		}
	}

	public void endTest() {
		extent.flush();
		extent.endTest(logger);
	}

	public void endReport() {
		extent.close();
	}

}
