package testCases;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountCreatedPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;

public class TC001_AccountRegistrationTest extends Baseclass {
	     
	@Test
	public void Verify_Account_Registration() {
		logger.info("----------------testcase1 Started ----------");
		
		HomePage hp=new HomePage(driver);
		boolean messagehomepage= hp.homepagedisplay();
		//System.out.println(messagehomepage); 
		Assert.assertEquals(messagehomepage, true);
		hp.clicksignup();
		logger.info("Clicked on sign up link");
		
		LoginPage lp= new LoginPage(driver);
		//RandomStringUtils rm=new Random();
		String name=RandomStringUtils.randomAlphabetic(7);
		lp.setTxtName(name);
		String email=lp.setTxtEmail(name+"@gmail.com");
        lp.setBtnsignup();	
        logger.info("Clicked on sign up button");
        
        SignUpPage signup=new SignUpPage(driver);
        System.out.println(signup.setAccountInformationDisplay());
        signup.setSelectTitle();
        logger.info("Clicked on Title");
        signup.setTxtName(name);
        signup.setTxtpassword("98989898");
        signup.setSelectdaydrop("1");
        signup.setSelectmonthdrop("June");
        signup.setSelectyeardrop("1993");
        signup.setChkNewletter();
        signup.setChkSpecialoffer();
        signup.setTxtfirstName("donalt");
        signup.setTxtlastName("Trump");
        signup.setTxtCompanyname("EXABEAM");
        signup.setTxtAdressLine1("KALA ROAD");
        signup.setTxtAdressline2("WAKAD");
        signup.setSelectCountry("India");
        signup.setTxtState("maharashtra");
        signup.setTxtCity("pune");
        signup.setTxtZipCode("422334");
        signup.setTxtMobNum("9999999999");
        
        signup.clickBtnCreateAccount();
        
        logger.info("Account created");
        AccountCreatedPage AccountpageCreated= new AccountCreatedPage(driver);
        AccountpageCreated.getCreatmessage();
        AccountpageCreated.clickBtncontinue();  
        logger.info("Clicked on continue button");
        
        HomePage hp1=new HomePage(driver);
        //Assert.assertTrue(hp.verifylogindone());
        logger.info("verifing logged succesfully");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // १. Ad च्या मेन iFrame मध्ये switch करा
            List<WebElement> frames = driver.findElements(By.xpath("//iframe[contains(@id,'aswift') or contains(@id,'google_ads_iframe')]"));
            if (!frames.isEmpty()) {
                driver.switchTo().frame(frames.get(0));

                // २. जर आत अजून nested iframe असेल तर switch करा
                List<WebElement> nestedFrames = driver.findElements(By.xpath("//iframe[@id='ad_iframe']"));
                if (!nestedFrames.isEmpty()) {
                    driver.switchTo().frame("ad_iframe");
                }

                // ३. Dismiss/Close बटन शोधून क्लिक करा
                List<WebElement> dismissBtn = driver.findElements(By.xpath("//div[@id='dismiss-button'] | //span[text()='Close'] | //div[contains(@aria-label,'Close')]"));
                if (!dismissBtn.isEmpty()) {
                    dismissBtn.get(0).click();
                }

                driver.switchTo().defaultContent();
            }
        } catch (Exception e) {
            driver.switchTo().defaultContent();
        }
        hp1.clickDelete();
        System.out.println("okkkkkkk");
        logger.info("click on delete account link");
        Assert.assertTrue(hp.verifydeletmessage());
        logger.info(" Accont deleted successfully");
        hp.clickContinuedelete();
        logger.info(" Click on Continur btn");
        logger.info("------testcase1 passed!!! -------------");
        
	}
	}


