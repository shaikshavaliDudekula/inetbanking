package pom_utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pom_testcases.BaseClass;




public class TestList extends BaseClass implements ITestListener {
	
	public ExtentHtmlReporter htmlReporter;

	public ExtentReports extent;

	public ExtentTest logger;
	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	

	

	public void onStart(ITestContext testContext)

	{

		//time stamp

		String repName="Test-Report-"+timeStamp+".html";

		

		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report

		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");

		

		extent=new ExtentReports();

	

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Host name","localhost");

		extent.setSystemInfo("Environemnt","QA");

		extent.setSystemInfo("user","shaiksha");

		

		htmlReporter.config().setDocumentTitle("InetBanking Test Project"); // Tile of report

		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report

		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart

		htmlReporter.config().setTheme(Theme.DARK);

	}

	

	public void onTestSuccess(ITestResult tr)

	{

		logger=extent.createTest(tr.getName()); // create new entry in th report

		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted

	}

	

	public void onTestFailure(ITestResult tr)

	{

		logger=extent.createTest(tr.getName()); // create new entry in th report

		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		//ITestContext context=tr.getTestContext();
		//WebDriver driver=(WebDriver)context.getAttribute("driver");
		try {
			screenshot(driver,tr.getName());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String screenshotPath=System.getProperty("user.dir")+"\\screenshots\\"+timeStamp+tr.getName()+".png";

		

		File f = new File(screenshotPath); 

		

		if(f.exists())

		{

		try {

			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));

			} 

		catch (IOException e) 

				{

				e.printStackTrace();

				}

		}

		

	}

	

	public void onTestSkipped(ITestResult tr)

	{

		logger=extent.createTest(tr.getName()); // create new entry in th report

		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));

	}

	

	public void onFinish(ITestContext testContext)

	{

		extent.flush();

	}

	public void screenshot(WebDriver driver,String imgname) throws IOException
	{
		//TakesScreenshot ts = (TakesScreenshot) driver;
		//File source = ts.getScreenshotAs(OutputType.FILE);
		//File target = new File( "./screenshots/" + imgname + ".png");
		//FileUtils.copyFile(source, target);
		File scr=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scr,new File("./screenshots/"+timeStamp+imgname+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot taken");
	}


}
