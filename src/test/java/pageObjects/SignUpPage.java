package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testCases.Baseclass;

public class SignUpPage extends Baseclass {
	
	WebDriver ldriver;
	
	//constructor
	public SignUpPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//b[normalize-space()='Enter Account Information']")
	WebElement AccountInformationDisplay;
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement selectTitle;
	@FindBy(xpath="//input[@id='name']")
	WebElement txtName;
	@FindBy(xpath="//input[@id='email']")
	//input[@id='email']
	WebElement txtEmail;
	@FindBy(xpath="//input[@id='password']")
	WebElement txtpassword;
	@FindBy(xpath="//select[@id='days']")
	WebElement selectdaydrop;
	@FindBy(xpath="//select[@id='months']")
	WebElement selectmonthdrop;
	@FindBy(xpath="//select[@id='years']")
	WebElement selectyeardrop;
	@FindBy(xpath="//input[@id='newsletter']")
	WebElement chkNewletter;
	@FindBy(xpath="//input[@id='optin']")
	WebElement chkSpecialoffer;
	@FindBy(xpath="//input[@id='first_name']")
	WebElement txtfirstName;
	@FindBy(xpath="//input[@id='last_name']")
	WebElement txtlastName;
	@FindBy(xpath="//input[@id='company']")
	WebElement txtCompany;
	@FindBy(xpath="//input[@id='address1']")
	WebElement txtAdress1;
	@FindBy(xpath="//input[@id='address2']")
	WebElement txtAdress2;
	@FindBy(xpath="//select[@id='country']")
	WebElement selectCountry;
	@FindBy(xpath="//input[@id='state']")
	WebElement txtState;
	@FindBy(xpath="//input[@id='city']")
	WebElement txtCity;
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement txtZipCode;
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement txtMobNum;
	@FindBy(xpath="//button[@data-qa='create-account']")
	WebElement btnCreateAccount;
	
	public String setAccountInformationDisplay() {
		
		 AccountInformationDisplay.isDisplayed();
		return AccountInformationDisplay.getText();
		
	}
	public void setSelectTitle() {
		selectTitle.click();
	}
	public void setTxtName(String name) {
		txtName.clear();
		txtName.sendKeys(name);
	}
	public void setTxtEmail(String Email) {
		txtEmail.clear();
		txtEmail.sendKeys(Email);
	}
	public void setTxtpassword(String password) {
		txtpassword.sendKeys(password);
	}
	public void setSelectdaydrop(String day) {
		Select selectobj=new Select (selectdaydrop);
		selectobj.selectByVisibleText(day);
		
	}
	public void setSelectmonthdrop(String month) {
		Select selectobj=new Select (selectmonthdrop);
		selectobj.selectByVisibleText(month);
	}
	public void setSelectyeardrop(String year) {
		Select selectobj=new Select (selectyeardrop);
		selectobj.selectByVisibleText(year);
	}
	public void setChkNewletter() {
		chkNewletter.click();
	}
	public void setChkSpecialoffer() {
		chkSpecialoffer.click();
	}
	public void setTxtfirstName(String firstName) {
		txtfirstName.sendKeys(firstName);
	}
	public void setTxtlastName(String lastName) {
		txtlastName.sendKeys(lastName);
	}
	public void setTxtCompanyname(String Company) {
		txtCompany.sendKeys(Company);
	}
	public void setTxtAdressLine1(String Adress1) {
		txtAdress1.sendKeys(Adress1);;
	}
	public void setTxtAdressline2(String Adress2) {
		txtAdress2.sendKeys(Adress2);
	}
	public void setSelectCountry(String Country) {
		Select selectobj=new Select (selectCountry);
		selectobj.selectByVisibleText(Country);
	}
	public void setTxtState(String State) {
		txtState.sendKeys(State);
	}
	public void setTxtCity(String City) {
		txtCity.sendKeys(City);
	}
	public void setTxtZipCode(String ZipCode) {
		txtZipCode.sendKeys(ZipCode);;
	}
	public void setTxtMobNum(String MobNum) {
		txtMobNum.sendKeys(MobNum);;
	}
	
	public void clickBtnCreateAccount() {
		
		 //btnCreateAccount.sendKeys(Keys.ENTER);
		 btnCreateAccount.click();
	}
	public void setTxtMobNum(Keys enter) {
		// TODO Auto-generated method stub
		
	}
	
}
