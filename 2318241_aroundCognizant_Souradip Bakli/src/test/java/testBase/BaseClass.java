package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.HomePage;
import pageObjects.NewsPage;
import utilities.ExplicitWait;


public class BaseClass {
	public static WebDriver driver;
	public Properties property;
	public ExplicitWait explicitWait;
	public HomePage homepage;
	public NewsPage newsPage;
	public Logger logger;
	
	@BeforeClass
	@Parameters({"Browser"})
	public void setup(String browser) throws IOException {
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		property  = new Properties();
		property.load(file);
		logger = LogManager.getLogger(this.getClass());
		
		switch(browser.toLowerCase()) {
			case "chrome":{
				driver = new ChromeDriver();
				break;
			}
			case "edge":{
				driver = new EdgeDriver();
				break;
			}
			default: {
				System.out.println("No matching browser found");
				return;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.navigate().to(property.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}
}
