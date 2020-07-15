package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import Utils.BrowserFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class Report {

	private static ExtentTest test;
	private static String REPORT_PATH = System.getProperty("user.dir") + "\\target\\ExtentReport\\";
	private static ExtentReports extent;
	private static String date = new SimpleDateFormat("dd_MMMM_yyyy").format(new Date());
	private static String project="ECS_";
	private  static String path=REPORT_PATH+date+"\\"+project+".html";
	
	public String getReportPath() {
		return path;
			}
	
	public synchronized static ExtentReports report() {
		System.out.println("report is intialized");
		extent=new ExtentReports(path,true);
		extent.addSystemInfo("Environment", "MMCS_QA").addSystemInfo("User Name", "Bhushan Borse");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extent.config.xml"));
		return extent;
	}
	
	public static void getreport(WebDriver driver) {	
		extent.flush();		
		driver.get(path);
		File file=new File(path);
		String path1="C:\\Report\\ECS.html";
		try {
			FileUtils.copyFile(file, new File(path1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//SendEmail.sendEmail(path1);
	}
	
	
}
