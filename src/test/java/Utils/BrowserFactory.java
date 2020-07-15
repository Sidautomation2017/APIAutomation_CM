package Utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	private static WebDriver driver = null;

	public static WebDriver selectBrowser(String browser) {
		//String path = System.getProperty("user.dir") + "\\src\\test\\resources\\BrowserDrivers";
		
		

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Sidheshwar.Tondare\\Desktop\\chromedriver_win32 (4)\\chromedriver.exe");
			driver = new ChromeDriver();
			/*
			 * WebDriverManager.chromedriver().version("83.0.4103.39").setup();
			 * ChromeOptions options = new ChromeOptions(); Map<String, Object> prefs = new
			 * HashMap<String, Object>(); prefs.put("credentials_enable_service", false);
			 * prefs.put("profile.password_manager_enabled", false);
			 * options.setExperimentalOption("prefs", prefs);
			 * options.setExperimentalOption("useAutomationExtension", false);
			 * options.setExperimentalOption("excludeSwitches",
			 * Collections.singletonList("enable-automation"));
			 * options.setPageLoadStrategy(PageLoadStrategy.EAGER); driver = new
			 * ChromeDriver(options);
			 */
//			System.setProperty("webdriver.chrome.driver", path + "\\chromedriver.exe"); 			
//			ChromeOptions options1 = new ChromeOptions();
//			driver = new ChromeDriver(options1);
			

			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		return driver;

	}

}