package com.inetbanking.testData;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;
import com.inetbanking.TestCases.BaseClass;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData")
public void loginDDT(String user,String pass) throws InterruptedException
{
	LoginPage lp=new LoginPage(driver);
	lp.setUsername(user);
	lp.setPassword(pass);
	lp.clickSubmit();
	Thread.sleep(1000);
	if(isAlertPresent()==true)
	{
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
	}
	else
	{
		Assert.assertTrue(true);
		lp.clickLogout();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
	}
}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException 
	{
		String path="C:\\Users\\Pavithra\\Desktop\\SeleniumMiniProject\\inteBankingV1\\src\\test\\java\\com\\inetbanking\\testData\\LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1",1);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=1;j<=colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata ;
	}
}
