package pom_testcases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;


import pom_testdata.Configuration;
@Listeners(pom_utilities.TestList.class)


public class BaseClass {
	public static WebDriver driver;
	Configuration config=new Configuration();
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		 logger=Logger.getLogger("ebanking");
			PropertyConfigurator.configure("Log4j.properties");
			
	if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",config.chromebrowser());
		driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		 else if(browser.equals("firefox")) {
		  System.setProperty("webdriver.gecko.driver",config.firefoxbrowser());
		 driver=new FirefoxDriver();
		 //driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); }
		driver.get(config.baseurl());
		
	}
	@AfterClass
	public void tearup()
	{
	driver.close();	
	}
	//for full page
//for specifi eliment
	
	  public void screenshot(WebElement ele,String imgname) throws IOException {
	  File scr=ele.getScreenshotAs(OutputType.FILE);
	 FileHandler.copy(scr,new File("./customerdetails/"+imgname+".png"));
	  
	  
	  
	  
		/*
		 * File screenshot = ((TakesScreenshot)
		 * driver).getScreenshotAs(OutputType.FILE); BufferedImage fullScreen =
		 * ImageIO.read(screenshot); //Find location of the webelement logo on the page
		 * Point location = logo.getLocation(); //Find width and height of the located
		 * element logo int width = logo.getSize().getWidth(); int height =
		 * logo.getSize().getHeight(); //Now the main point, which is cropping the full
		 * image to get only the logo screenshot BufferedImage logoImage =
		 * fullScreen.getSubimage(location.getX(), location.getY(), width, height);
		 * ImageIO.write(logoImage, "png", screenshot); //copy the file to the desired
		 * location FileUtils.copyFile(screenshot, new
		 * File("./customerdetails/"+imgname+".png"));
		 */
	  
	  }
	  public String randomemail()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(8);
			return generatedstring;
		}
		public String randomphone()
		{
			String generatephone=RandomStringUtils.randomNumeric(10);
			return generatephone;
		}
		public String randompin()
		{
			String generatepin=RandomStringUtils.randomNumeric(6);
			return generatepin;
		}
		public String randompwd()
		{
			String generatepwd=RandomStringUtils.randomAlphanumeric(6);
			return generatepwd;
		}
	 
}
