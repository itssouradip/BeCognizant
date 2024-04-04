/**
 * 
 */
package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author 2318241
 *
 */
public class TakeScreenShot {
	public String takeScreenShot(WebDriver driver) {

		// Creating a timestamp to use in the name of the Screenshot

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(".//screenshots/Screenshot-" + timeStamp + ".png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return destinationFile.getPath();
	}
}


