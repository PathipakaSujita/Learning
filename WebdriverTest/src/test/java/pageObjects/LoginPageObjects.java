package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import TestNG.Util;

public class LoginPageObjects {
	
	
	WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//input[@name='uid']")
	WebElement UseriDField;
	
	@FindBy(name="password")
	WebElement PasswordField;
	
	@FindBy(how=How.NAME, using="btnLogin")
	WebElement LoginBtn;
	
	public WebElement getUseriDField() {
		return UseriDField;
	}

	public void setUseriDField(WebElement useriDField) {
		UseriDField = useriDField;
	}

	public WebElement getPasswordField() {
		return PasswordField;
	}

	public void setPasswordField(WebElement passwordField) {
		PasswordField = passwordField;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		LoginBtn = loginBtn;
	}

	public LoginPageObjects(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
//	public static void login(String uname, String pwd) throws Exception{
//		UseriDField.clear();
//		UseriDField.sendKeys(uname);
//		PasswordField.clear();
//		PasswordField.sendKeys(pwd);
//		LoginBtn.click();
//		
//		
//	}

}
