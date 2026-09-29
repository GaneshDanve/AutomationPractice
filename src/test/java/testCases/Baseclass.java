package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
			ChromeOptions option = new ChromeOptions();
			File ext=new File("./ublock.crx");
			if(ext.exists()) {
				option.addExtensions(ext);
			}
			// 2. Chrome Save Address ani Autofill Popups BAND karnyasaathi Preferences
	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("autofill.profile_enabled", false); // Save Address popup band
	        prefs.put("autofill.credit_card_enabled", false);
	        prefs.put("credentials_enable_service", false); // Save Password popup band
	        prefs.put("profile.password_manager_enabled", false);
	        option.setExperimentalOption("prefs", prefs);

	        // 3. Automation notification ani extra popups disable kara
	        option.addArguments("--disable-popup-blocking");
	        option.addArguments("--disable-notifications");
	        option.addArguments("--disable-infobars");
	        option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			option.addArguments("--blink-settings=imagesEnabled=false");
			driver= new ChromeDriver(option);
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
	        
	        try {
	        	
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        if (driver.getCurrentUrl().contains("#google_vignette")) {
	            driver.navigate().refresh();
	        }}
	        catch(Exception e) {
	    	   
	       }}

	      @AfterClass 
	     public void tearDown() 
	    {
          if (driver!=null)
        { 	
		    driver.close();
	    	driver.quit();
     }
     }
	 
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
	

