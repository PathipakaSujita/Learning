package TestNG;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Util {

	public static final int WAIT_TIME = 30; // Delay time to wait the website
	// launch completely
	public static final String BASE_URL = "http://www.demo.guru99.com/";

	// Valid account for login
	public static final String USER_NAME = "mngr70640";
	public static final String PASSWD = "nUhYjad";
	public static final String NEW_PASSWD = "123456@";


	// Expected output
	public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
	public static final String EXPECT_loginPage_TITLE = "Guru99 Bank Home Page";

	public static final String EXPECT_ERROR = "User or Password is not valid";
	public static final String WRONG_OLDPWD_ALERTMSG="Old Password is incorrect";
	

	public static final String PATTERN = ":";
	public static final String FIRST_PATTERN = "mngr";
	public static final String SECOND_PATTERN = "[0-9]+";

	public static final String FIREFOX_PATH = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
	
	public static final String TESTDATA_PATH = "C:\\Users\\pathi\\git\\Learning\\WebdriverTest\\TestDataExcel.xlsx";
			 
	public static final String TESTDATA_FILE = "TestDataExcel.xlsx";
	
	public int num;

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
