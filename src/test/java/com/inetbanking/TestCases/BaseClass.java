package com.inetbanking.TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig rc=new ReadConfig();
	
	
public String BaseURL=rc.getApplicationURL();
public String username=rc.getUsername();
public String password=rc.getPassword();
public static WebDriver driver;


public static Logger logger;
@SuppressWarnings("deprecation")
@BeforeClass
public void setup()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pavithra\\Desktop\\SeleniumMiniProject\\inteBankingV1\\Drivers\\chromedriver.exe");
driver=new ChromeDriver();
 logger=Logger.getLogger("ebanking");
PropertyConfigurator.configure("Log4j.properties");

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get(BaseURL);

}

@AfterClass
public void tearDown()
{
	driver.quit();
}
}
