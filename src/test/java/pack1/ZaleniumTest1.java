package pack1;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ZaleniumTest1 {
	
	@Test
    public void runTestOnZaleniumNode() throws Exception {
        
		
		
	//System.setProperty("webdriver.chrome.driver", "C:/ECLIPSE_WORKSPACE/chromedriver.exe");
	  // String driverPath = System.getProperty("user.dir");
	    
		DesiredCapabilities ds = DesiredCapabilities.chrome();
		ds.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
		ds.setVersion("");
		ds.setCapability("zal:name", "Zalenium_Chrome_Calculator_Math_Percent");
		ds.setCapability("zal:build", "Zalenium_Chrome_TestBuild_Calculator_Math_Percent");
		ds.setCapability("zal:tz", "Europe/Helsinki");
		ds.setCapability("zal:screenResolution", "1280x720");
		ds.setCapability("zal:idleTimeout", "180");
		ds.setCapability("zal:recordVideo", "true");
		
		
	//RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), ds);
		
		//RemoteWebDriver driver = new ChromeDriver();
	
	//RemoteWebDriver driver=new RemoteWebDriver(new URL("http://173.193.79.174:32069//wd/hub"), ds);
	
String openshift_zalenium_url="https://zalenium-sayoghos-in-second.dc-ig-lib-exp-158711870-f72ef11f3ab089a8c677044eb28292cd-0000.au-syd.containers.appdomain.cloud//wd/hub";
	
		//String add="http://173.193.100.84:30754//wd/hub";
		
	RemoteWebDriver driver=new RemoteWebDriver(new URL(openshift_zalenium_url), ds);
		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	
String application_url="http://www.calculator.net/";

	driver.navigate().to(application_url);
	Thread.sleep(2000);

	// Click on Math Calculators
    driver.findElement(By.xpath("//*[@id='contentout']/table/tbody/tr/td[3]/div[2]/a")).click();
    
    // Click on Percent Calculators
    driver.findElement(By.xpath("//*[@id='content']/table[2]/tbody/tr/td/div[3]/a")).click();
    
    Thread.sleep(3000);
    
    // Enter value 10 in the first number of the percent Calculator
    driver.findElement(By.xpath("//*[@id='cpar1']")).sendKeys("10");
    
    Thread.sleep(2000);
    
    // Enter value 50 in the second number of the percent Calculator
     driver.findElement(By.xpath("//*[@id='cpar2']")).sendKeys("50");

    
    // Click Calculate Button
    driver.findElement(By.xpath("//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")).click();

    Thread.sleep(2000);
    // Get the Result Text based on its xpath
    String result =
       driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();

    
    // Print a Log In message to the screen
    //System.out.println(" The Result is " + result);
    
    Thread.sleep(500);
    
	driver.quit();
    
    


}
}
