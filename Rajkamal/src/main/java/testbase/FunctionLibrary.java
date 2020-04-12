

package testbase;


import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelUtilities.PropertyFieUtil;




public class FunctionLibrary {
	
	
	static WebDriver driver;
	
	public static WebDriver startBrowser() throws Exception{
		
		if(PropertyFieUtil.getValueforKey("Browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","F:\\MavenVenkat\\Rajkamal\\drivers\\chromedriver.exe");
		    driver=new ChromeDriver();
		}else if(PropertyFieUtil.getValueforKey("Browser").equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","F:\\MavenVenkat\\Rajkamal\\drivers\\chromedriver.exe");
			driver=new FirefoxDriver();
		}else if(PropertyFieUtil.getValueforKey("Browser").equalsIgnoreCase("ie")){
			System.setProperty("webdriver.internetexplorer.driver","F:\\MavenVenkat\\Rajkamal\\drivers\\chromedriver.exe");
			driver=new InternetExplorerDriver();
		}
		
		return driver;
		
		
		
	}
	
	public static void openApplication(WebDriver driver) throws Exception{	
		driver.get(PropertyFieUtil.getValueforKey("Url"));
		driver.manage().window().maximize();
	}
	
	public static void waitForElement(WebDriver driver,String locatortype,String locatorvalue,String waittitme){
		
		WebDriverWait mywait=new WebDriverWait(driver,Integer.parseInt(waittitme));
		
		if(locatortype.equalsIgnoreCase("id")){
		   mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
		}
		else if(locatortype.equalsIgnoreCase("name")){
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
		}else if(locatortype.equalsIgnoreCase("xpath"))
		{
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
		}else
		{
			System.out.println("unable to locate for waitForElement method");
		}
	}
	
	public static void typeAction(WebDriver driver,String locatortype,String locatorvalue,String testdata){
		
		if(locatortype.equalsIgnoreCase("id")){
			driver.findElement(By.id(locatorvalue)).clear();
		    driver.findElement(By.id(locatorvalue)).sendKeys(testdata);
		}
		else if(locatortype.equalsIgnoreCase("name")){
			driver.findElement(By.name(locatorvalue)).clear();
			driver.findElement(By.name(locatorvalue)).sendKeys(testdata);	
		}else if(locatortype.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locatorvalue)).clear();
			driver.findElement(By.xpath(locatorvalue)).sendKeys(testdata);	
		}else
		{
			System.out.println("Locator not matching for typeAction method");
		}
			
	}
	
	public static void clickAction(WebDriver driver,String locatortype,String locatorvalue){
		
		
		
		if(locatortype.equalsIgnoreCase("id")){
			driver.findElement(By.id(locatorvalue)).sendKeys(Keys.ENTER);
		}
		else if(locatortype.equalsIgnoreCase("name")){
			driver.findElement(By.name(locatorvalue)).click();	
		}else if(locatortype.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locatorvalue)).click();	
		}else
		{
			System.out.println("Locator not matching for clickAction method");
		}
	}
	
	public static void closeBrowser(WebDriver driver){
		driver.close();
	}
	
	public static String generateDate(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD-HH-mm-SS");
		
		return sdf.format(date);
	}
	
	
	
	
	

}

