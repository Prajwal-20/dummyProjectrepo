package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	public String readDataFromProperties(String key) throws IOException {
		 FileInputStream pfis = new FileInputStream("./configData/commonData.properties");
		 Properties prop = new Properties();
		 prop.load(pfis);
		String data = prop.getProperty(key);
		 return data;
		 
	 }
}
