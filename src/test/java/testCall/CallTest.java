package testCall;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import base.YamlReader;




public class CallTest {
	
	@Test
	public void readYml(){
//		System.out.println("url: "+YamlReader.getData("url"));
		System.out.println("baseurl:FinalReturn From parseMap "+YamlReader.getData("baseurl"));
		String url= YamlReader.getData("baseurl");
//		FirefoxDriver ff = new FirefoxDriver();
		FirefoxBinary fb = new FirefoxBinary(new File("C:\\Program Files (x86)\\MozillaFirefox16\\firefox.exe"));
		FirefoxDriver driver = new FirefoxDriver(fb,null);
		driver.get(url);
		driver.quit();//mvn test or mvn clean test
	}
	

}
