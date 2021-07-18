package pom_inetbanking_objectrepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pom_addcustomer {
	WebDriver ldriver;
	
	public Pom_addcustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(how=How.XPATH,using="//a[contains(text(),'New Customer')]")
	WebElement lnknewcustomer;
	@FindBy(how=How.NAME,using="name")
	WebElement cname;
	@FindBy(how=How.NAME,using="rad1")
	WebElement gender;
	@FindBy(how=How.NAME,using="dob")
	WebElement dob;
	@FindBy(how=How.NAME,using="addr")
	WebElement address;
	@FindBy(how=How.NAME,using="city")
	WebElement city;
	@FindBy(how=How.NAME,using="state")
	WebElement state;
	@FindBy(how=How.NAME,using="telephoneno")
	WebElement phone;
	@FindBy(how=How.NAME,using="emailid")
	WebElement email;
	@FindBy(how=How.NAME,using="password")
	WebElement password;
	@FindBy(how=How.NAME,using="sub")
	WebElement submit;
	@FindBy(how=How.NAME,using="pinno")
	WebElement pinnum;
	public void addcustomer()
	{
		lnknewcustomer.click();
	}
	public void customerpin(String pnum)
	{
		pinnum.sendKeys(pnum);
	}
	public void customername(String name)
	{
		cname.sendKeys(name);
	}
	public void customergender()
	{
		gender.click();
	}
	public void dateofbirth(String day,String month,String year)

	{
		dob.sendKeys(day);
		dob.sendKeys(month);
		dob.sendKeys(year);
	}
	public void customercity(String cityname)
	{
		city.sendKeys(cityname);
	}
	public void customeradress(String adress)
	{
		address.sendKeys(adress);
	}
	public void phonenumber(String pnumber)
	{
		phone.sendKeys(pnumber);
	}
	public void customerstate(String statename)
	{
		state.sendKeys(statename);
	}
	
	public void customeremail(String emailaddress)
	{
		email.sendKeys(emailaddress);
	}
	
	public void customerpass(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void submit()
	{
		submit.click();
	}
	
}
