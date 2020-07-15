package Runner;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pojo.CreateEquipmentOrder;

//import com.cm.base.BrowserFactory;
//import com.cm.base.Constant;

import Repositories.RequestPayLoad_EquipmentOrder;
import Repositories.RequestPayload_InhouseFleet;
import Utils.Configuration;
import Utils.Report;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class EquipmentOrder_TestCases extends TestSuite {
	public static int orderNo;

	@Test(priority = 0, enabled = true)
	public void createEqpOrder() {

		RestAssured.baseURI = "https://cm-kcsr-ecs-qa-api.cloudmoyo.com";

		for (CreateEquipmentOrder ce : CEOData) {
			System.out.println("===========Test case is started");
		
		

			logger = extent.startTest("createEqpOrder");

			try {

				Response resp = given().log().all().header("Authorization", authToken)
						.header("Content-Type", "application/json").body(ce).when().log().all()
						.post(Configuration.createEOResource).then().log().all().statusCode(201).extract().response();

				String res = resp.asString();
				JsonPath js = new JsonPath(res);
				orderNo = js.get("orderNumber");
				System.out.println(orderNo);
				
				logger.log(LogStatus.PASS, "API is run successfully");

			} catch (Exception e ) {
				e.printStackTrace();
				logger.log(LogStatus.FAIL, e.toString());
			}
			catch ( AssertionError error) {
				
				logger.log(LogStatus.FAIL, error);
				
			}
		}

	}

	@Test(priority = 1, enabled = false)
	public static void editEqpOrder() {
		RestAssured.baseURI = "https://cm-kcsr-ecs-qa-api.cloudmoyo.com";

		Response resp = given().log().all().header("Authorization", authToken)
				.header("Content-Type", "application/json")
				.body(RequestPayLoad_EquipmentOrder.editOrderRequestPayload()).when().log().all()
				.post(Configuration.editEOResource).then().assertThat().log().all().statusCode(200).extract()
				.response();

		String res = resp.asString();
		JsonPath js = new JsonPath(res);
		int orderNo = js.get("orderNumber");
		int revisedCars = js.get("revisedNumberOfCarsOrdered");
		System.out.println(orderNo);
		System.out.println(revisedCars);

	}

	@Test(priority = 2, enabled = false)
	public static void getOrderDetails() {
		Response resp = given().log().all().header("Authorization", authToken)
				.header("Content-Type", "application/json").body(RequestPayLoad_EquipmentOrder.getOrderDetails()).when()
				.log().all().post(Configuration.getOrderResource).then().assertThat().log().all().statusCode(200)
				.extract().response();

		String res = resp.asString();
		JsonPath js = new JsonPath(res);
		// extracting the order number
		int orderNo = js.get("orderNumber");
		// extracting the routescac from the json
		String routescac = js.getString("destinationRoute.get(0).routeSCAC");
		// extracting the date required on
		String date = js.getString("orderQuantity.get(0).equipmentDateRequiredOn");
		// extracting the order status for getorder
		String eqpOrderStatus = js.getString("orderStatus");
		System.out.println(orderNo);
		System.out.println(routescac);
		System.out.println(date);
		System.out.println(eqpOrderStatus);
	}

	@Test(priority = 3, enabled = false)
	public static void listOfEO() {
		RestAssured.baseURI = "https://cm-kcsr-ecs-qa-api.cloudmoyo.com";

		Response resp = given().log().all().header("Authorization", authToken)
				.header("Content-Type", "application/json")
				.body(RequestPayLoad_EquipmentOrder.listOfEOWithOptionalParams()).when().log().all()
				.post(Configuration.listEOResource).then().assertThat().log().all().statusCode(200).extract()
				.response();

		String res = resp.asString();
		JsonPath js = new JsonPath(res);
		int orderNo = js.get("emptyCarOrders.get(0).orderNumber");
		System.out.println(orderNo);
	}

	@Test(priority = 4, enabled = false)
	public static void cancelEO() {
		RestAssured.baseURI = "https://cm-kcsr-ecs-qa-api.cloudmoyo.com";

		given().log().all().header("Authorization", authToken).header("Content-Type", "application/json")
				.body(RequestPayLoad_EquipmentOrder.cancelEqpOrderWithOptionalParams()).when().log().all()
				.post(Configuration.cancelEOResource).then().assertThat().log().all().statusCode(200).extract()
				.response();

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus()==ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "API working fine ");
		} else if (result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getThrowable().getMessage());
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test is skipped");
		}
	}

}
