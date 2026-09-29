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

	@FindBy(xpath="//h2[text()='Login to your account']")
	WebElement verify_log_into_your_account;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement textCorretEmailAdress;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
	WebElement textCorretPassword;
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	WebElement btnlogin;
	
	
	public void setTxtName(String Name) {
		txtName.sendKeys(Name);
	}

	public String setTxtEmail(String Email) {
		txtEmail.sendKeys(Email);
		return Email;
	}

	public void setBtnsignup() {
		btnsignup.click();
	}
	
	public boolean verifyLogintoyouraccount() {
	       return verify_log_into_your_account.isDisplayed();
	}
	
	public void entremailadress_signIn(String correctemailadress) {
		textCorretEmailAdress.sendKeys(correctemailadress);
	}
	public void entrepassword_signIn(String correctpossword) {
		textCorretPassword.sendKeys(correctpossword);
	}
	public void clickloginBtn() {
		btnlogin.click();
	}
	}
