package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class Baseclass {

	ReadConfig readconfig = new ReadConfig();
    String baseurl = readconfig.getBaseurl();
	String browser = readconfig.getBrowser();

	public static WebDriver driver;
	public static Logger logger;
   
	
	@BeforeClass
	public void setup()
	    {
	
		//for logging
		logger=LogManager.getLogger("Automation_Practice");
		
		switch(browser.toLowerCase())
		{
		    case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;

			case "msedge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();			
			break;
			default:
			System.out.println("Wrong Browser name please check properties file");
			break;
           }
            driver.manage().window().maximize();
            logger.info("Url open..!");
	        driver.get(baseurl);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	       }

	     // @AfterClass
	  //   public void tearDown() 
	//     {
//          if (driver!=null)
//        { 	
//		    driver.close();
//	    	driver.quit();
//        }
//     }
	 
	 public static void captureScreenShot(WebDriver driver, String testName) throws IOException
		    {
		    	
		    	//step 2: Convert WebDriver objet to TakeScreenShot interface
		    	TakesScreenshot screenshot= (TakesScreenshot)driver;
		    	
		    	//step2 : call getScreenshotAs method to create image file
		    	
		    	File src= screenshot.getScreenshotAs(OutputType.FILE);
		    	
		    	String destpath= System.getProperty("user.dir") + "\\screenshots\\" + testName + ".png";
		    	
		    	File dest =new File (destpath );
		    	
		    	//step 3: copy image file to destination
		    	
		    	FileUtils.copyFile(src,dest);
		    	}
		    }
	

