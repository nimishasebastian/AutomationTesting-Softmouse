package com.Selenium.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.Selenium.qa.util.TestUtil;
import com.Selenium.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver; 
	public static Properties prop;
	public  static EventFiringDecorator e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\nimis\\eclipse-workspace\\Selenium-framework\\src\\main"
					+ "\\java\\com\\Selenium\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void initialization() {
		String browserName =prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nimis\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		
		
		 eventListener = new WebEventListener();
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener);
        driver = decorator.decorate(driver);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));	
		
		
	}
	
	public static void switchToNewWindow() {
	    String currentWindow = driver.getWindowHandle();

	    // Wait until more than one window is open
	    int retry = 0;
	    while (driver.getWindowHandles().size() == 1 && retry < 5) {
	        try {
	            Thread.sleep(1000); // wait for 1 second
	            retry++;
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    for (String windowHandle : driver.getWindowHandles()) {
	        if (!windowHandle.equals(currentWindow)) {
	            driver.switchTo().window(windowHandle);
	            break;
	        }
	    }
	}

}
