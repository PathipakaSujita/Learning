package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteAcPageObjects {
	
	WebDriver driver;
	@FindBy(how=How.LINK_TEXT, using="Delete Account")  WebElement deleteAcLink;
	
	@FindBy(how=How.NAME,using="accountno") WebElement acNo;
	
	@FindBy(how=How.NAME,using="AccSubmit") WebElement acDelSubmit;
	
	//@FindBy(how=How.LINK_TEXT,using="Mini Statement") WebElement miniStatementLink;
	@FindBy(how=How.XPATH,using="/html/body/div[2]/div/ul/li[13]/a") WebElement miniStatementLink;

	
	@FindBy(how=How.NAME,using="accountno") WebElement MiniStatementacNo;
	
	@FindBy(how=How.NAME,using="AccSubmit") WebElement miniStatementAcSubmit;

	

	
	
	public WebElement getMiniStatementLink() {
		return miniStatementLink;
	}


	public void setMiniStatementLink(WebElement miniStatementLink) {
		this.miniStatementLink = miniStatementLink;
	}


	public WebElement getMiniStatementacNo() {
		return MiniStatementacNo;
	}


	public void setMiniStatementacNo(WebElement miniStatementacNo) {
		MiniStatementacNo = miniStatementacNo;
	}


	public WebElement getMiniStatementAcSubmit() {
		return miniStatementAcSubmit;
	}


	public void setMiniStatementAcSubmit(WebElement miniStatementAcSubmit) {
		this.miniStatementAcSubmit = miniStatementAcSubmit;
	}


	public WebElement getDeleteAcLink() {
		return deleteAcLink;
	}


	public void setDeleteAcLink(WebElement deleteAcLink) {
		this.deleteAcLink = deleteAcLink;
	}


	public WebElement getAcNo() {
		return acNo;
	}


	public void setAcNo(WebElement acNo) {
		this.acNo = acNo;
	}


	public WebElement getAcDelSubmit() {
		return acDelSubmit;
	}


	public void setAcDelSubmit(WebElement acDelSubmit) {
		this.acDelSubmit = acDelSubmit;
	}


	public DeleteAcPageObjects(WebDriver driver){
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	

}
