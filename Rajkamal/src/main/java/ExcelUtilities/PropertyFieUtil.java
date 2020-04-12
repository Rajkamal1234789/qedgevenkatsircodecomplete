package ExcelUtilities;

import java.io.FileInputStream;

import java.util.Properties;

public class PropertyFieUtil {

	public static String getValueforKey( String key) throws Exception{
	
FileInputStream fis=new FileInputStream("F:\\MavenVenkat\\Rajkamal\\src\\main\\java\\ExcelUtilities\\Propertyfile");
 Properties pro=new Properties();
 pro.load(fis);
 return pro.getProperty(key);
 
 
	}

}
