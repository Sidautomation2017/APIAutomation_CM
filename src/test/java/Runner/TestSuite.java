package Runner;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Pojo.CreateEquipmentOrder;
import Utils.BrowserFactory;
import Utils.Configuration;
import Utils.ExcelReader;
import Utils.Report;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestSuite extends Report{
	
	protected static ExtentReports extent ;
	public static ExtentTest logger;	
	public static String authToken;
	protected static WebDriver driver;
	public static List<CreateEquipmentOrder> CEOData;
	@BeforeSuite()
	public static void generateAuthToken() {
		
		extent=report();

		//String requestPayload = "\"B737109EC0A6C596104210711AD222FBBED75D2D0FFF6F0CB1EC5A45D71EE4E3AC018DECD436A57CF04B55E85057AA62F1BB76C57D5BF9EA88926D5109B7F0E9\"";
		RestAssured.baseURI = Configuration.baseurl;

		Response resp = given().log().all().queryParam("Organization", Configuration.organization)
				.header("Content-Type", "application/json").body(Configuration.requestPayloadAuthToken).when().log().all()
				.contentType(io.restassured.http.ContentType.JSON).post(Configuration.authTokenResource).then().assertThat()
				.statusCode(200).extract().response();

		String res = resp.asString();
		authToken = "Bearer " + res;
		System.out.println(authToken);

	}
	
	
	@BeforeTest()
	public void dataSetUp() throws IOException {		
		ExcelReader reader = new ExcelReader();
		CEOData = reader.getEquipmentOrderData("TestData.xlsx", "CreateEquipmentOrder");	
		
		
	}
	
	 @AfterSuite 
	 public void afterSuite()
	 
	 { 
		 System.out.println("In After Suite");
		 driver=BrowserFactory.selectBrowser("chrome");				
		 getreport(driver);
		 
 }
	 
	
	

}
