package com.inetbanking.TestCases;


import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;

public class TC_Login extends BaseClass
{
@Test
public void loginTest()
{
	driver.get(BaseURL);
	logger.info("URL is opened");
	LoginPage lp=new LoginPage(driver);
	lp.setUsername(username);
	logger.info("Entered Username");
	lp.setPassword(password);
	logger.info("Entered password");
	lp.clickSubmit();
	
}
public void TestCode()
{
	System.out.println("Testing");
}
}
