package TestNG;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChromeLoginUsingDataDriven {
private WebDriver driver;
private String baseUrl;
int num = 0;
Logger log = Logger.getLogger("ChromeLoginUsingDataDriven"); // creating logger


//Setup Test environment
	@BeforeMethod
	public void setUpChrome() throws Exception {
		log.info("Invoking Browser");
		System.setProperty("webdriver.chrome.driver","D://Skills/Sel/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		
		baseUrl = Util.BASE_URL;
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		driver.get(baseUrl + "/v4/");
	}	

	
  @Test(dataProvider="Authentication")
  public void loginVerifyUsingExcelData(String xusername,String xpassword) throws Exception {
	// Enter valid username
			driver.findElement(By.name("uid")).clear();
			driver.findElement(By.name("uid")).sendKeys(xusername);

			// Enter valid password
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(xpassword);

			// Click Login
			driver.findElement(By.name("btnLogin")).click();
  }
			
			@AfterMethod
			public void afterTest() throws Exception {
				log.info("Browser is being closed");
				driver.quit();		 
  }

    @DataProvider
 
    public Object[][] Authentication() throws Exception{
 
         Object[][] testObjArray = Util_ManagingExcelFile.getTableAsArray("D:\\Skills\\Sel Stuff\\Guru Project\\Project 1\\TestDataExcel.xlsx","TestDataSheet");
 
         return (testObjArray);
   
		}
 
    	
}