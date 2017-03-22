package TestNG;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import pageObjects.AddCustomerPageObjects;
import pageObjects.ChangePasswordPageObjects;
import pageObjects.DeleteAcPageObjects;
import pageObjects.HomePageObjects;

public class PasswordResetTC {
	WebDriver driver;
	String baseUrl = null;
	Logger log=Logger.getLogger("PasswordResetTC");
	String AcNo;
	

	@BeforeTest
	public void setupBrowser() throws Exception {
		PropertyConfigurator.configure("C:\\Users\\pathi\\git\\Learning\\WebdriverTest\\Log4j.properties");
		System.setProperty("webdriver.chrome.driver", "D://Skills/Sel/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		baseUrl = Util.BASE_URL;
		driver.get(baseUrl + "/v4/");
		
	}

	@Test(priority=1)
	public void loginWithGivenCredentials() throws Exception {
		LoginPageObjects loginpgobj = new LoginPageObjects(driver);
		loginpgobj.getUseriDField().clear();
		loginpgobj.getUseriDField().sendKeys(Util.USER_NAME);
		loginpgobj.getPasswordField().clear();
		loginpgobj.getPasswordField().sendKeys(Util.NEW_PASSWD);
		loginpgobj.getLoginBtn().click();
		
		HomePageObjects homepgobj = new HomePageObjects(driver);
		String welcomeMsg=homepgobj.getLoginWelcomeBlock().getText();
		//System.out.println(welcomeMsg.equals("Manger Id : " + Util.USER_NAME));
		Assert.assertEquals(welcomeMsg, "Manger Id : " + Util.USER_NAME);
		
		homepgobj.getChangePasswordLink().click();
		
		
		ChangePasswordPageObjects pwdchangepgobj = new ChangePasswordPageObjects(driver);

		pwdchangepgobj.getOldPasswordfield().sendKeys("12345");
		pwdchangepgobj.getNewPasswordfield().sendKeys(Util.NEW_PASSWD);
		pwdchangepgobj.getConfirmpasswordfield().sendKeys(Util.NEW_PASSWD);
		pwdchangepgobj.getPwdChangeSubmitBtn().click();
		
		String wrongOldPwdAlert=driver.switchTo().alert().getText();
		
		Assert.assertEquals(wrongOldPwdAlert, Util.WRONG_OLDPWD_ALERTMSG);
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank New Customer Entry Page");
		
	}
	
	@Test(priority=2)
	public void changePassword() throws Exception{
		LoginPageObjects loginpgobj = new LoginPageObjects(driver);
		HomePageObjects homepgobj = new HomePageObjects(driver);
		ChangePasswordPageObjects pwdchangepgobj = new ChangePasswordPageObjects(driver);

		pwdchangepgobj.getOldPasswordfield().sendKeys(Util.NEW_PASSWD);
		pwdchangepgobj.getNewPasswordfield().sendKeys(Util.NEW_PASSWD);
		pwdchangepgobj.getConfirmpasswordfield().sendKeys(Util.NEW_PASSWD);
		pwdchangepgobj.getPwdChangeSubmitBtn().click();
		
		String pwdChangeSuccess= driver.switchTo().alert().getText();
		Assert.assertEquals(pwdChangeSuccess, "Password is Changed");
		
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.getTitle(), Util.EXPECT_loginPage_TITLE);
	}
	
	@Test(priority=3)
	public void loginAfterPwdChange(){
		LoginPageObjects loginpgobj = new LoginPageObjects(driver);
		HomePageObjects homepgobj = new HomePageObjects(driver);
		ChangePasswordPageObjects pwdchangepgobj = new ChangePasswordPageObjects(driver);
		
		loginpgobj.getUseriDField().sendKeys(Util.USER_NAME);
		loginpgobj.getPasswordField().sendKeys(Util.NEW_PASSWD);
		loginpgobj.getLoginBtn().click();
		Assert.assertEquals(homepgobj.getLoginWelcomeBlock().getText(), "Manger Id : " + Util.USER_NAME);

		HomePageObjects.NewCustomerLink.click();
		
	}
	
	@Test(priority=4)
	public void addCustomer() throws Exception{
		HomePageObjects homepgobj = new HomePageObjects(driver);
		AddCustomerPageObjects customerpgobj=new AddCustomerPageObjects(driver);
		homepgobj.getNewCustomerLink().click();
		System.out.println(driver.getTitle());
		
		Boolean gvalue=false;
		
		customerpgobj.getCustomerName().sendKeys("Sujitha");
		customerpgobj.getGender();
		customerpgobj.getDob().sendKeys("10/08/1993");
		customerpgobj.getAddress().sendKeys("98 Plymouth Drive");
		customerpgobj.getCity().sendKeys("Iselin");
		customerpgobj.getState().sendKeys("NJ");
		customerpgobj.getPinno().sendKeys("088300");
		customerpgobj.getTelephoneno().sendKeys("9052355422");
		customerpgobj.getEmailid().sendKeys("chuchumaven4@gmail.com");
		customerpgobj.getPassword().sendKeys(Util.NEW_PASSWD);
		customerpgobj.getSubmit().click();
		
		String CustomerID =driver.findElement(By.xpath(".//*[@id='customer']/tbody/tr[4]/td[2]")).getText();
		driver.findElement(By.linkText("New Account")).click();
	//	<a href="addAccount.php">New Account</a>
		//Customer ID 34256
	
		customerpgobj.getCustomerID().sendKeys(CustomerID);
		
		Select accountType=new Select(customerpgobj.getChooseAc());
		accountType.selectByVisibleText("Savings");
		
		customerpgobj.getInitialDeposit().sendKeys("500");
		customerpgobj.getAddAcSubmit().click();
			
		//linktext=Delete Account
		//name=accountno
		//name=AccSubmit
		//get alert text. assert
		// accept alert
	
	}
	
	@Test(priority=5)
	public void deleteAccount() throws Exception{
		
		AcNo= driver.findElement(By.xpath("//*[@id='account']/tbody/tr[4]/td[2]")).getText();
		System.out.println(AcNo);
		
		
		DeleteAcPageObjects delAcPgObj= new DeleteAcPageObjects(driver);
		delAcPgObj.getDeleteAcLink().click();
		delAcPgObj.getAcNo().sendKeys(AcNo);
		delAcPgObj.getAcDelSubmit().click();
		
		/*DeleteAcPageObjects.deleteAcLink.click();
		DeleteAcPageObjects.acNo.sendKeys(AcNo);
		DeleteAcPageObjects.acDelSubmit.click();*/
		
		String alertDeleteAc =driver.switchTo().alert().getText();
		System.out.println(alertDeleteAc);
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		String afterDeleting=driver.switchTo().alert().getText();
		System.out.println(afterDeleting);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		/*driver.findElement(By.partialLinkText("Mini Statement")).click();
		//delAcPgObj.getMiniStatementLink().click();
		
		
		delAcPgObj.getMiniStatementacNo().sendKeys(AcNo);
		
		delAcPgObj.getMiniStatementAcSubmit().click();
		
		String alertAfterAcDeleted=driver.switchTo().alert().getText();
		System.out.println(alertAfterAcDeleted);
		
		driver.switchTo().alert().accept();
*/
	
			
	}
	
	@Test(priority=6)
	public void miniStatementCheck()throws Exception{
		DeleteAcPageObjects delAcPgObj= new DeleteAcPageObjects(driver);
		System.out.println(AcNo);
		driver.findElement(By.partialLinkText("Mini Statement")).click();
		//delAcPgObj.getMiniStatementLink().click();
		 /*Actions action =new Actions(driver);
		 action.click();*/
		
		delAcPgObj.getMiniStatementacNo().sendKeys(AcNo);
		
		delAcPgObj.getMiniStatementAcSubmit().click();
		
		String alertAfterAcDeleted=driver.switchTo().alert().getText();
		System.out.println(alertAfterAcDeleted);
		
		driver.switchTo().alert().accept();
	}
	/*@AfterTest
	public void afterMethod() throws Exception {

		driver.quit();

	}*/

}
