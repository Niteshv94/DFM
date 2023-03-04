/**
 * 
 */
package com.dfm.utility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.dfm.utility.TestTimeUtil;

/**
 * @author Nitesh
 *
 */
public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String applicationURL)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(browserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Sorry We don't support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(applicationURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		return driver;
	}
	
	
	public static void quitbrowser(WebDriver driver)
	{
		//driver.quit();
		
	}

}
