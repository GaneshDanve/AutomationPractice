package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.Baseclass;

public class LoginPage extends Baseclass {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//input[@name='name']")
	WebElement txtName;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//button[@data-qa='signup-button']")
	WebElement btnsignup;

	
	public void setTxtName(String Name) {
		txtName.sendKeys(Name);
	}

	public void setTxtEmail(String Email) {
		txtEmail.sendKeys(Email);
	}

	public void setBtnsignup() {
		btnsignup.click();
	}
	
	
	}
