package pom_testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom_inetbanking_objectrepositry.Pom_Loginpage;
import pom_utilities.TestList;
import pom_utilities.UtilityXL;
public class TestCase_02 extends BaseClass {
	

@Test(dataProvider="logindata")	
public void loginpage(String username,String pwd) throws InterruptedException, IOException
{
	Pom_Loginpage lg=new Pom_Loginpage(driver);
	logger.info("browser launched");
			logger.info("baseurl opened");
			
			String path= "./utilities/logindetails.xlsx";
			//String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
			System.out.println(path);
			System.out.println(username);
			  System.out.println(pwd);
			lg.username(username);
			
			logger.info("entered username");
			
			
			  lg.password(pwd); 
			 
			  logger.info("entered password");
			  lg.lbutton();
			  logger.info("submitted");
			  Thread.sleep(3000);
			  if(isAlertPresent()==true)
				{
				  
					driver.switchTo().alert().accept();//close alert
					
					driver.switchTo().defaultContent();
					logger.info("Login failed");
					TestList ss=new TestList();
					ss.screenshot( driver,"addNewCustomer");
					  Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
					logger.info("Login passed");
					lg.logout();
					Thread.sleep(3000);
					driver.switchTo().alert().accept();//close logout alert
					driver.switchTo().defaultContent();
					
				}
				
				
			}
			
			
			public boolean isAlertPresent() //user defined method created to check alert is presetn or not
			{
				try
				{
				driver.switchTo().alert();
				return true;
				}
				catch(NoAlertPresentException e)
				{
					return false;
				}
				
			}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
@DataProvider(name="logindata")	
public Object[][]getlogin() throws IOException
{
	String path="./utilities/logindetails.xlsx";
	UtilityXL data=new UtilityXL(path);
	int rows=data.getRowscount("sheet1");
	int cols=data.getcolumnscount("sheet1", 1);
	Object getdata[][]=new Object[rows][cols];
	for(int i=1;i<=rows;i++)
	{
		for(int j=0;j<cols;j++)
		{
			getdata[i-1][j]=data.getcellvalue("sheet1", i, j);
		}
	}
	return getdata;
	
}
	

}
