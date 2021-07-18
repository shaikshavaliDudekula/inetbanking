package pom_testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pom_inetbanking_objectrepositry.Pom_Loginpage;

public class TestCase_01 extends BaseClass{
	
	@Test
	public void login() throws IOException, InterruptedException
	{
	
		Pom_Loginpage lg=new Pom_Loginpage(driver);
logger.info("browser launched");
		
		logger.info("baseurl opened");
		lg.username(config.uname());
		
		logger.info("entered username");
		
		
		  lg.password(config.password()); 
		  logger.info("entered password");
		  lg.lbutton();
		  logger.info("submitted");
		  Thread.sleep(3000);
		  String expected="Guru99 Bank Manager HomePage"; 
		  String actual=driver.getTitle();
		  
		  if(actual.equals(expected))
		  {
			  logger.info("test passed");
		  Assert.assertTrue(true);
		  
		  
		  }
		  else
		  {
			  logger.info("test failed");
			 
			  Assert.assertTrue(false);
				
		  }
	}

}
