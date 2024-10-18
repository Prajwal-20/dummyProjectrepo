package vtiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.PropertyFileUtility;

public class WindowHandle {

	public static void main(String[] args) throws IOException, InterruptedException {
	//@Test
	//	public void addToCart()throws IOException {
		WebDriver driver = null ;
		FileInputStream fis = new FileInputStream("./ConfigData/commonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		String browser = pro.getProperty("Browser");
		String url = pro.getProperty("Link");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement searchtxt = driver.findElement(By.id("twotabsearchtextbox"));
		searchtxt.sendKeys("iphone 13");
		searchtxt.submit();
		
		driver.findElement(By.linkText("Apple iPhone 13 (128GB) - Midnight")).click();
		
		String parentid = driver.getWindowHandle();
		System.out.println(parentid);
		Set<String> ids = driver.getWindowHandles();
		ids.remove(parentid);
		for(String currentid: ids) {
			
			driver.switchTo().window(currentid);
			System.out.println(currentid); 
			driver.findElement(By.xpath("(//div[@class='a-button-stack']/descendant::span[@class='a-declarative'])[2]")).click();
			
			
			
		}
	    
		
		
			
	
		
		
		
		
		}

	}


