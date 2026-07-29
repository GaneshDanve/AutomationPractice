package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.Baseclass;

public class AccountCreatedPage extends Baseclass
{
	WebDriver ldriver;
	public AccountCreatedPage(WebDriver rdriver)
	{
	this.ldriver=rdriver;
	PageFactory.initElements(driver, this);
	}
    
    @FindBy(xpath="//p[text()='Congratulations! Your new account has been successfully created!']")
    WebElement creatsucessmessage;
    @FindBy(xpath="//a[@data-qa=\"continue-button\"]")
    WebElement btncontinue;
	
    public boolean getCreatmessage() {
    	return creatsucessmessage.isDisplayed();
	}
	public void clickBtncontinue() {
		btncontinue.click();
	}
    
    
}
