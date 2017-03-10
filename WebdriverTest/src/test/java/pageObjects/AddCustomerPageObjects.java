package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPageObjects {
	WebDriver driver;
	
	@FindBy(how=How.NAME,using="name") WebElement customerName;

	@FindBy(how=How.NAME,using="rad1") WebElement gender;
	
	@FindBy(how=How.NAME,using="dob") WebElement dob;
	
	@FindBy(how=How.NAME,using="addr") WebElement address;
	
	@FindBy(how=How.NAME,using="city") WebElement city;

	@FindBy(how=How.NAME,using="state") WebElement state;
	
	@FindBy(how=How.NAME,using="pinno") WebElement pinno;
	
	@FindBy(how=How.NAME,using="telephoneno") WebElement telephoneno;
	
	@FindBy(how=How.NAME,using="emailid") WebElement emailid;
	
	@FindBy(how=How.NAME,using="password") WebElement password;

	@FindBy(how=How.NAME,using="sub") WebElement submit;

	@FindBy(how=How.NAME,using="res") WebElement reset;
	
	//After Customer created, info is displayed . Now create new account
	@FindBy(how=How.NAME,using="cusid") WebElement customerID;
	
	@FindBy(how=How.NAME, using="selaccount") WebElement ChooseAc;
	
//	Select accountType=new Select(ChooseAc);
	
	@FindBy(how=How.NAME,using="inideposit") WebElement initialDeposit;
	
	@FindBy(how=How.NAME, using="button2") WebElement addAcSubmit;

	//<select name="selaccount" style="width:175px">
	/*<option value="Savings">Savings</option>
	<option value="Current">Current</option>
	
	<input name="inideposit" maxlength="8" onkeyup="validateinideposit();" onblur="validateinideposit();" type="text"/>
	
	<input name="button2" value="submit" onclick="return validateAddAccount();" type="submit"/>
	*/
	
	
	
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getCustomerID() {
		return customerID;
	}


	public void setCustomerID(WebElement customerID) {
		this.customerID = customerID;
	}


	public WebElement getChooseAc() {
		return ChooseAc;
	}


	public void setChooseAc(WebElement chooseAc) {
		ChooseAc = chooseAc;
	}


	public WebElement getInitialDeposit() {
		return initialDeposit;
	}


	public void setInitialDeposit(WebElement initialDeposit) {
		this.initialDeposit = initialDeposit;
	}


	public WebElement getAddAcSubmit() {
		return addAcSubmit;
	}


	public void setAddAcSubmit(WebElement addAcSubmit) {
		this.addAcSubmit = addAcSubmit;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getCustomerName() {
		return customerName;
	}


	public void setCustomerName(WebElement customerName) {
		this.customerName = customerName;
	}


	public WebElement getGender() {
		return gender;
	}


	public void setGender(WebElement gender) {
		this.gender = gender;
	}


	public WebElement getDob() {
		return dob;
	}


	public void setDob(WebElement dob) {
		this.dob = dob;
	}


	public WebElement getAddress() {
		return address;
	}


	public void setAddress(WebElement address) {
		this.address = address;
	}


	public WebElement getCity() {
		return city;
	}


	public void setCity(WebElement city) {
		this.city = city;
	}


	public WebElement getState() {
		return state;
	}


	public void setState(WebElement state) {
		this.state = state;
	}


	public WebElement getPinno() {
		return pinno;
	}


	public void setPinno(WebElement pinno) {
		this.pinno = pinno;
	}


	public WebElement getTelephoneno() {
		return telephoneno;
	}


	public void setTelephoneno(WebElement telephoneno) {
		this.telephoneno = telephoneno;
	}


	public WebElement getEmailid() {
		return emailid;
	}


	public void setEmailid(WebElement emailid) {
		this.emailid = emailid;
	}


	public WebElement getPassword() {
		return password;
	}


	public void setPassword(WebElement password) {
		this.password = password;
	}


	public WebElement getSubmit() {
		return submit;
	}


	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}


	public WebElement getReset() {
		return reset;
	}


	public void setReset(WebElement reset) {
		this.reset = reset;
	}


	public AddCustomerPageObjects(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
