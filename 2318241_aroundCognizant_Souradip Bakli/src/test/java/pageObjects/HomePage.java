package pageObjects;

import testBase.BasePage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// Constructor for the HomePage
	public HomePage(WebDriver driver){
		super(driver);
	}
	public static List<WebElement>sectionNews=null;
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	// Locating the WebElements
	@FindBy(xpath="(//div[@data-automation-id='CanvasZone'])[1]") WebElement canvasZone;
	@FindBy(xpath="//div[@id='meInitialsButton']") WebElement btnMyProfile;
	@FindBy(xpath="//div[@id='mectrl_currentAccount_primary']") WebElement txtName;
	@FindBy(xpath="//div[@id='mectrl_currentAccount_secondary']") WebElement txtEmail;
	@FindBy(xpath = "//*[text()='Around Cognizant']") WebElement sectionAroundCognizant;
	@FindBy(xpath="//div[@class='ez_i_91bed31b']//a[@id='news_text_title']")
	static List<WebElement> lSectionNews;
	@FindBy(xpath="//span[@class='fontSizeMedium']") WebElement btnSeeAll;
	
	
	// Action Methods
	
	
	
	public void clickMyProfile() {
		//btnMyProfile.click();
		Actions ac = new Actions(driver);
		ac.moveToElement(btnMyProfile).perform();
		ac.doubleClick(btnMyProfile).perform();
		ac.doubleClick(btnMyProfile).perform();
	}
	public void singleClickMyProfile() {
		btnMyProfile.click();
		
	}
	public String getName() {
		String str = txtName.getText();
		return str;
	}
	public String getEmail() {
		String str = txtEmail.getText();
		return str;
	}
	
//	public void scrollHome() {
//		jse.executeScript("arguments[0].scrollIntoView();", canvasZone);
//	}
	
	public boolean  isSectionTitleVisible() {
		boolean sectionTitle = sectionAroundCognizant.isDisplayed();
		return sectionTitle;
	}

	
	public List<WebElement> sectionNewsElement() {
		return lSectionNews;
	}
	public List<String> sectionNews(){
		List<String> str = new ArrayList<>();
		for(WebElement i : sectionNewsElement()) {
			str.add(i.getText());
			
		}return str;
	}
	
	
	public boolean isSeeAllEnabled() {
		boolean status = btnSeeAll.isEnabled();
		return status;
	}
	
	public void clickSeeAll() {
		btnSeeAll.click();
	}
	
}
