package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public Properties property;
	
	public void propertyReader() throws IOException {
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		property = new Properties();
		property.load(file);
	}
	
	public String readURL() {
		String appURL = property.getProperty("appURL");
		return appURL;
	}
	
	public static void main(String[] args) {
		PropertyReader pr = new PropertyReader();
		System.out.println(pr.readURL());
		
//		String s = PropertyReader.readURL();
//		System.out.println(s);
	}
}
