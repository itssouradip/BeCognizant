package pageObjects;

import testBase.BasePage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NewsPage extends BasePage {
	
	// Constructor for BookShelvesPage
	public NewsPage(WebDriver driver) {
		super(driver);
	}
	
	// Locating the elements
	
	@FindBy(xpath="//div[@data-automation-id='BaseCollection-FreshData']//span [text()='News']") WebElement tagNews;
	@FindBy(xpath="//div[@class='ms-List-page']//a[@id='news_text_title']")
	static List<WebElement> lNewsFull;
	
	// Action methods
	public String txtTag() {
		String str = tagNews.getText();
		return str;
	}
	public List<String> allNews(){
		List<String> str = new ArrayList<>();
		for(WebElement i : lNewsFull) {
			str.add(i.getText());
			
		}return str;
	}
	
}
