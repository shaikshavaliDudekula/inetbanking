package pom_inetbanking_objectrepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_Loginpage {
WebDriver driver;
public Pom_Loginpage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name="uid")
public
WebElement userid;
@FindBy(name="password")
WebElement password;
@FindBy(name="btnLogin")
WebElement logbutton;
@FindBy(xpath="//a[contains(text(),'Log out')]")
WebElement logout;
public void logout()
{
	logout.click();
}

public void username(String uid)
{
	userid.sendKeys(uid);
}
public void password(String pwd)
{
	password.sendKeys(pwd);
}
public void lbutton()
{
	logbutton.click();
}
}
