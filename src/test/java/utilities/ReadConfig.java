package utilities;

import java.io.FileInputStream;
import java.util.Properties;

    public class ReadConfig {
	
	Properties prop;
	String filepath=System.getProperty("user.dir")+"\\Configuration\\config.properties";
    
	//Constructor
	public ReadConfig() {
	try {
		
		prop=new Properties();
			
		FileInputStream fis=new FileInputStream(filepath);
		
        prop.load(fis);
			} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    }
		
		public String getBaseurl() {
			String urlvalue=prop.getProperty("baseurl");
			
			if (urlvalue!=null) 
				return urlvalue;
				else 
					throw new RuntimeException("url value not present in properties file ");
				}
		
		public String getBrowser() {
            String browservalue=prop.getProperty("browser");
			
			if (browservalue!=null) 
				return browservalue;
				else 
					throw new RuntimeException("browser value not present in properties file ");
				}
	           }
	


