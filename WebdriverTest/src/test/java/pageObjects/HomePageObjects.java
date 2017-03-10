package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	WebDriver driver;
	
	@FindBy(how=How.XPATH, using="html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
	 WebElement LoginWelcomeBlock;
	
	@FindBy(how=How.LINK_TEXT, using="Change Password")
	WebElement ChangePasswordLink;
	
	@FindBy(how=How.LINK_TEXT, using="New Customer")
	public static WebElement NewCustomerLink;
	
	
	public static WebElement getNewCustomerLink() {
		return NewCustomerLink;
	}



	public static void setNewCustomerLink(WebElement newCustomerLink) {
		NewCustomerLink = newCustomerLink;
	}



	public WebElement getLoginWelcomeBlock() {
		return LoginWelcomeBlock;
	}



	public void setLoginWelcomeBlock(WebElement loginWelcomeBlock) {
		LoginWelcomeBlock = loginWelcomeBlock;
	}



	public WebElement getChangePasswordLink() {
		return ChangePasswordLink;
	}



	public void setChangePasswordLink(WebElement changePasswordLink) {
		ChangePasswordLink = changePasswordLink;
	}



	public HomePageObjects(WebDriver driver){
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
	
}
