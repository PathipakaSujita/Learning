package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPageObjects {

	WebDriver driver;
	@FindBy(how=How.NAME, using="oldpassword") 
	WebElement oldPasswordfield;
	
	@FindBy(how=How.NAME, using="newpassword")
	WebElement newPasswordfield;
	
	public WebElement getOldPasswordfield() {
		return oldPasswordfield;
	}

	public void setOldPasswordfield(WebElement oldPasswordfield) {
		this.oldPasswordfield = oldPasswordfield;
	}

	public WebElement getNewPasswordfield() {
		return newPasswordfield;
	}

	public void setNewPasswordfield(WebElement newPasswordfield) {
		this.newPasswordfield = newPasswordfield;
	}

	public WebElement getConfirmpasswordfield() {
		return confirmpasswordfield;
	}

	public void setConfirmpasswordfield(WebElement confirmpasswordfield) {
		this.confirmpasswordfield = confirmpasswordfield;
	}

	public WebElement getPwdChangeSubmitBtn() {
		return pwdChangeSubmitBtn;
	}

	public void setPwdChangeSubmitBtn(WebElement pwdChangeSubmitBtn) {
		this.pwdChangeSubmitBtn = pwdChangeSubmitBtn;
	}

	@FindBy(how=How.NAME, using="confirmpassword")
	WebElement confirmpasswordfield;
	
	@FindBy(how=How.NAME, using="sub")
	WebElement pwdChangeSubmitBtn;
	
	public ChangePasswordPageObjects(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*public static void changePwd(String oldpwd, String newpwd, String confirmpwd){
		oldPasswordfield.sendKeys(oldpwd);
		newPasswordfield.sendKeys(newpwd);
		confirmpasswordfield.sendKeys(confirmpwd);
		pwdChangeSubmitBtn.submit();
	}*/
	 
	
}
