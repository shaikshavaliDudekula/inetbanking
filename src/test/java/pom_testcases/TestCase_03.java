package pom_testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pom_inetbanking_objectrepositry.Pom_Loginpage;
import pom_inetbanking_objectrepositry.Pom_addcustomer;
public class TestCase_03 extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		Pom_Loginpage lp=new Pom_Loginpage(driver);
		
		
		lp.username(config.uname());
		logger.info("entered username");
		lp.password(config.password());
		logger.info("entered password");
		lp.lbutton();
		logger.info("login successful");
		Thread.sleep(3000);
		
		Pom_addcustomer ac=new Pom_addcustomer(driver);
		ac.addcustomer();
		logger.info("addcustomer clicked");
		ac.customername("shaiksha");
		ac.customergender();
		ac.dateofbirth("30", "06", "1989");
		
		Thread.sleep(3000);
		ac.customeradress("ttdaa");
		ac.customercity("hyderabad");
		ac.customerstate("telangana");
		String pin=randompin();
		ac.customerpin(pin);
		String pnumber=randomphone();
		ac.phonenumber(pnumber);
		String email=randomemail()+"@gmail.com";
		ac.customeremail(email);
		String pwd=randompwd();
		ac.customerpass(pwd);
		
		ac.submit();
		logger.info("entered newuser details");
		Thread.sleep(3000);
		boolean scr=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(scr==true)
		{
			logger.info ("customer added successfully");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement ele=driver.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[1]/td[1]"));
			//js.executeScript("window.scrollBy(0,250)", "");
			js.executeScript("arguments[0].scrollIntoView();", ele);
			
			screenshot(ele,pwd);
			logger.info ("captured customer details");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("test failed");
			
			Assert.assertTrue(false);
		
			
		}
	}
	
	
}

