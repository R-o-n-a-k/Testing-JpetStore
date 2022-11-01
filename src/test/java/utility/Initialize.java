package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Initialize {
	public JavascriptExecutor jse;
	public static ReportGenertor report;
	public WebDriver driver;

	public Initialize()  {
		System.setProperty("webdriver.chrome.driver",
				"C:\\CAPGEMINI\\Training\\Module 4\\Selenium demo\\jpetstore\\src\\test\\resources\\drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();

		this.jse = (JavascriptExecutor) driver;


	}
	public static void reportInitialization() {
        report = new ReportGenertor();
    }
}
