package pom_testdata;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {
	Properties pro;
	public Configuration() 
	{
		File src= new File("./configuration/configuration.properties");
		try {
		FileInputStream fi=new FileInputStream(src);
		pro= new Properties();
		pro.load(fi);
		}
		catch (Exception e)
		{
		System.out.print("exception is"+e.getMessage())	;
		}
	}
	public String baseurl()
	{
		String url=pro.getProperty("baseurl");
		return url;
		
	}
	public String uname()
	{
		String uname=pro.getProperty("username");
		return uname;
		
	}
	public String password()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}
	public String chromebrowser()
	{
		String chrome=pro.getProperty("chromepath");
		return chrome;
	}
	public String firefoxbrowser()
	{
		String chrome=pro.getProperty("firefoxpath");
		return chrome;
	}


}
