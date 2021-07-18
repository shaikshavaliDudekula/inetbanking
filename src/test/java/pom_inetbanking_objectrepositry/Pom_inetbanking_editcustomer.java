package pom_inetbanking_objectrepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pom_inetbanking_editcustomer {
	WebDriver driver;
	
	Pom_inetbanking_editcustomer(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="cusid")
	WebElement cid;
	
	@FindBy(name="AccSubmit")
	WebElement submit;

	

	@FindBy(how=How.NAME,using="addr")
	WebElement adr;
	@FindBy(how=How.NAME,using="city")
	WebElement city;
	@FindBy(how=How.NAME,using="state")
	WebElement state;
	@FindBy(how=How.NAME,using="telephoneno")
	WebElement phone;
	@FindBy(how=How.NAME,using="emailid")
	WebElement password;
	@FindBy(how=How.NAME,using="pinno")
	WebElement pinnum;
	@FindBy(name="Sub")
	WebElement editsubmit;
	
	
public void editAddress(String address)

{
	adr.sendKeys(address);
}


	
	public void customerId(String id)
	{
		cid.sendKeys(id);
	}
	public void accSubmitBtn()
	{
	submit.click();
	}
	
}
