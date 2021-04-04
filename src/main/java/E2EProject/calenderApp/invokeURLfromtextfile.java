package E2EProject.calenderApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;




public class invokeURLfromtextfile extends mainClass {

   

	public String geturl() throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("/Users/bingis/eclipse-workspace/calenderApp/src/main/java/E2EProject/calenderApp/Data.properties");
		prop=new Properties();
		prop.load(fis);
		String websitename=prop.getProperty("url");
		return websitename;
	}
}
