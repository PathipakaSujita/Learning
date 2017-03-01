package TestNG;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirefoxLoginUsingDataProvider {
	private WebDriver driver;
	private String baseUrl;
	int num = 0;
	Logger log = Logger.getLogger("FirefoxLoginUsingDataProvider"); // creating logger

	@DataProvider(name = "GuruTest")
	public Object[][] testData() {
		PropertyConfigurator.configure("C:\\Users\\pathi\\workspace\\WebdriverTest\\Log4j.properties"); // configuring
																										// properties
																										// file
																										// into
																										// logger

		log.info("data is loaded into a 2 dimensional array");
		Object[][] data = new Object[4][2]; // Creating a 4*2 matrix for 4 cases
											// and 2 variables

		// first row
		data[0][0] = Util.USER_NAME;
		data[0][1] = Util.PASSWD;
		// second row
		data[1][0] = "invalidu";
		data[1][1] = Util.PASSWD;
		// third row
		data[2][0] = Util.USER_NAME;
		data[2][1] = "invalidp";
		// fourth row
		data[3][0] = "invalidu";
		data[3][1] = "invalidp";

		return data;
	}

	// Setup Test environment
	@BeforeMethod
	public void setUp() throws Exception {
		log.info("Invoking Browser");
		System.setProperty("webdriver.gecko.driver", "D://Skills/Sel/geckodriver-v0.13.0-win64/geckodriver.exe");
		File pathToBinary = new File(Util.FIREFOX_PATH);
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile ffProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary, ffProfile);

		baseUrl = Util.BASE_URL;
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		driver.get(baseUrl + "/v4/");
	}

	@Test(dataProvider = "GuruTest")
	public void testcaseFirefox(String username, String password) throws Exception {
		String actualTitle;
		String actualBoxMsg;

		// Enter valid username
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(username);

		// Enter valid password
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);

		// Click Login
		driver.findElement(By.name("btnLogin")).click();
		log.info("Credentials are entered and login button is pressed");
		log.info("Screenshot is taken");


		try {
			/*
			 * WebDriverWait wait=new WebDriverWait(driver,5);
			 * wait.until(ExpectedConditions.alertIsPresent());
			 */
			Thread.sleep(6000);
			Alert alt = driver.switchTo().alert();
			Util.takeSnapShot(driver, "D:\\Skills\\Sel Stuff\\Guru Project\\Project 1\\screenshotinvalidlogin" + num + ".png");
			actualBoxMsg = alt.getText();
			alt.accept();
			Assert.assertEquals(actualBoxMsg, Util.EXPECT_ERROR);
			log.error("invalid credentials");
		} catch (NoAlertPresentException Ex) {
			String pageText = driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[3]/td"))
					.getText();
			String[] parts = pageText.split(Util.PATTERN);
			String dynamicText = parts[1];

			Assert.assertTrue(dynamicText.substring(1, 5).equals(Util.FIRST_PATTERN));

			String remain = dynamicText.substring(dynamicText.length() - 5);

			Assert.assertTrue(remain.matches(Util.SECOND_PATTERN));
			log.info("manager Id got printed on the screen");

			Util.takeSnapShot(driver, "D:\\Skills\\Sel Stuff\\Guru Project\\Project 1\\screenshotvalidlogin.png");

			/*
			 * //CODE TO TAKE SCREENSHOT
			 * System.out.println("take success screenshot");
			 * 
			 * File
			 * srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE
			 * );
			 * 
			 * FileUtils.copyFile(srcFile, new
			 * File("D:\\Skills\\Sel Stuff\\Guru Project\\Project 1\\screenshot.png"
			 * ));
			 */
		}
		num = num + 1;
	}

	@AfterMethod
	public void afterTest() throws Exception {
		log.info("Browser is being closed");
		driver.quit();

	}

}
