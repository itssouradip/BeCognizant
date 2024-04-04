/**
 * 
 */
package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 2318241
 *
 */
public class ExplicitWait {
public static WebDriverWait wait;

	public void myProfileVisibility(WebDriver driver) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"O365_MainLink_Settings\"]/div")));
	}
	public void txtNameEmailVisibility(WebDriver driver) {
//		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mectrl_truncate'][@id='mectrl_currentAccount_secondary']")));
	}

	public void newsVisibility(WebDriver driver) {
//		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ez_i_91bed31b']//a[@id='news_text_title']")));
	}
	
	public void homeVisibility(WebDriver driver) {
//		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".m_b_beed2cf1.l_b_beed2cf1.o_b_beed2cf1.p_b_beed2cf1")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".c_a_beed2cf1")));
	}
	
	public void newsFullVisibility(WebDriver driver) {
		
//		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ms-List-page']//a[@id='news_text_title']")));
		
	}
	public void newsTitle(WebDriver driver) {
//		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='title_text']")));
	}
	public void newsDescription(WebDriver driver) {
//		wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='CanvasComponent']")));
	}
	
}
