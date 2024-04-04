package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.NewsPage;
import testBase.BaseClass;
import utilities.ExplicitWait;
import utilities.TakeScreenShot;

/***********************************************************************************
*																				   *
* Author		 : Souradip Bakli(2318241)                                         *                                       *
* Class Name     : AroundCognizant                                                 * 
* Description    : To Test the all the test cases.                                 *
*                                                                                  *
************************************************************************************/

public class AroundCognizant extends BaseClass{
	TakeScreenShot screenShot = new TakeScreenShot();
	@Test(priority=0)
	public void verifyAccount() {
		logger.info("**** Starting of TestCases for Around Cognizant ****");
		logger.info("** Captured user info **");
		try {
		homepage = new HomePage(driver);
		ExplicitWait explicitWait = new ExplicitWait();
		logger.info("Waiting for loading My Profile iocn");
		explicitWait.myProfileVisibility(driver);
		Thread.sleep(2500);
		logger.info("Click on My Profile button");
		homepage.clickMyProfile();
		explicitWait.txtNameEmailVisibility(driver);
		String email = homepage.getEmail();
		String name = homepage.getName();
		System.out.println(email);
		System.out.println(name);
		screenShot.takeScreenShot(driver);
		logger.info("Printing User Info on console");
		}
		catch(Exception e) {
			logger.info("** User info verification failed or not found");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
		
	}
	
	@Test(priority=1)
	public void verifyAroundCognizant() {
		logger.info("** Verifying presence of Around Cognizant section **");
		
		try {
		homepage=new HomePage(driver);
		logger.info("Checking if Around Cognizant is visible");
		boolean status=homepage.isSectionTitleVisible();
		Assert.assertEquals(status, true);
		logger.info("** Presence of Around Cognizant section is verified **");
		}
		catch(Exception e) {
			logger.info("** Can't able to find Around Cognizant Section **");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
	}
	
	@Test(priority=2)
	public void verifyNewsinHomePage(){
		logger.info("** Start verifying News in NewsSection by tooltip **");
		try {
		homepage=new HomePage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//SoftAssert sa=new SoftAssert();
//		driver.navigate().refresh();
		ExplicitWait explicitWait = new ExplicitWait();
		logger.info("Scrolling Window by 650 pixel to get News");
		js.executeScript("document.getElementsByClassName('c_a_beed2cf1')[0].scrollBy(0,650)");
//		homepage.scrollHome();
		explicitWait.newsVisibility(driver);

		logger.info("Making a list of news");
		List<WebElement>newsElement=homepage.sectionNewsElement();
		logger.info("Start verifying News by their tooltip");
		for(int i=0;i<newsElement.size();i++) {			
			Assert.assertEquals(newsElement.get(i).getText(),newsElement.get(i).getAttribute("title"),"news of index "+(i+1)+" is not matching : ");
			System.out.println(newsElement.get(i).getText());
		}
		logger.info("** News section is verified with tooltip **");
		}
		catch(Exception e) {
			logger.info("** Verification of News in NewsSection by tooltip failed **");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
	}
	
	@Test(priority=3)
	public void verifySeeAllBtn() {
		logger.info("** Start verifying seeAll button **");
		try {
		homepage=new HomePage(driver);
		logger.info("Check if seeAll is enabled");
		boolean status = homepage.isSeeAllEnabled();
		Assert.assertEquals(status, true);
		logger.info("** seeAll button is enabled **");
		}
		catch(Exception e) {
			logger.info("** See all button is not enabled **");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
	}
	
	@Test(priority=4)
	public void clickSeeAllBtn() {
		try {
		homepage=new HomePage(driver);
		homepage.clickSeeAll();
		logger.info("** Clicked on see All button **");
		}catch(Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}
	}
	
	@Test(priority=5)
	public void checkHeadingVisibility() {
		logger.info("** Checking if Heanding is visible after clicking **");
		try {
		newsPage = new NewsPage(driver);
		String actHeading = newsPage.txtTag();
		String expHeading = "News";
		Assert.assertEquals(actHeading, expHeading);
		logger.info("** Heading is visible **");
		}catch(Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
			logger.info("** Heading is not visible **");
		}
	}
	
	@Test(priority=6) 
	public void verifyNewsInNewsPage() {
		logger.info("** Start verifying News in Newspage **");
		try {
		ExplicitWait explicitWait = new ExplicitWait();
		logger.info("navigating back to collect data for validation");
		driver.navigate().back();
		explicitWait.homeVisibility(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('c_a_beed2cf1')[0].scrollBy(0,650)");
//		homepage.scrollHome();
		explicitWait.newsVisibility(driver);
		homepage=new HomePage(driver);
		List<String>news=homepage.sectionNews();
		driver.navigate().forward();
		logger.info("navigating forward");
		
		
		SoftAssert sa=new SoftAssert();
		newsPage = new NewsPage(driver);
		logger.info("Switching driver back to News page");
		
		explicitWait.newsFullVisibility(driver);
		List<String>newsFull = newsPage.allNews();
		logger.info("Making a list from News page");
		
//		System.out.println(newsFull.size());
		logger.info("Verifying news heading with their tooltip");
		for(int i=0;i<news.size();i++) {
			System.out.println("News page news: "+newsFull.get(i));
			System.out.println("Homepage news: "+news.get(i));
			sa.assertEquals(news.get(i),newsFull.get(i),"newsFull of index "+(i+1)+"is not matching");
			sa.assertAll();
		}
		logger.info("** News in Newspage verified **");
		}
		catch(Exception e) {
			logger.info("** News heading verification with their tooltip failed **");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
	}
	
	@Test(priority=7)
	public void verifyfullNews() {
		logger.info("** Start printing all full details of news on console  **");
		try {
		ExplicitWait explicitWait = new ExplicitWait();
		
		for(int i=0;i<5;i++) {
			driver.findElement(By.xpath("(//div[@class='ms-List-page']//a[@id='news_text_title'])["+(i+1)+"]")).click();
			explicitWait.newsTitle(driver);
			Assert.assertEquals(driver.findElement(By.id("title_text")).getText(),driver.findElement(By.xpath("//div[@aria-level='1']")).getAttribute("title"),"newsFull of index "+(i+1)+"is not matching");
			System.out.println(" \n");
			System.out.println(driver.findElement(By.id("title_text")).getText());
			explicitWait.newsDescription(driver);
			System.out.println(driver.findElement(By.xpath("//div[@class='CanvasComponent']")).getText());
			System.out.println(" \n");
			driver.navigate().back();
			explicitWait.newsFullVisibility(driver);
		}
		logger.info("** All details of news printed on console **");
		}catch(Exception e) {
			logger.info("** An exception occured during printing all full details of news on console  **");
			Assert.fail("An exception occurred: " + e.getMessage());			
		}
		logger.info("**** Ending of TestCases for Around Cognizant ****");
	}

}
