package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	public static File file;  
	public static FileInputStream fileInput;
	public static Properties properties;		
	public static String baseurl,testEnv,organization,authTokenResource,createEOResource,editEOResource,
	cancelEOResource,getOrderResource,listEOResource,requestPayloadAuthToken, custNo, custName,requestingId,
	createInhouseFleetResouce,updateInhouseFleetResouce,getInhouseFleetResouce,deleteInhouseFleetResouce,
	inhouseFleetInquiryResouce,inhouseFleetEquipmentInquiryResource, kcsmdb, kcsrdb, inhouseFleetName,effectiveDate, expiryDate;
	public static String currentdir=System.getProperty("user.dir");
	static String path=currentdir+"\\src\\test\\resources\\configuration.properties";
	public static int config_wait,polling_wait;
	public static String dataSetUp;	
	
	

	static {
		
		file=new File(path);
		try {
			fileInput=new FileInputStream(file);
			properties=new Properties();
			properties.load(fileInput);
			baseurl=properties.getProperty("BASEURI");
			testEnv=properties.getProperty("Environment");
			organization=properties.getProperty("Organization");
			authTokenResource=properties.getProperty("AuthorizationTokenAPIResource");
			createEOResource=properties.getProperty("CreateOrderAPIResouce");			
			editEOResource=properties.getProperty("EditOrderAPIResouce");
			cancelEOResource=properties.getProperty("CancelOrderAPIResouce");
			getOrderResource=properties.getProperty("GetOrderAPIResouce");
			listEOResource=properties.getProperty("ListOfOrderAPIResouce");
			createInhouseFleetResouce= properties.getProperty("CreateInhouseFleet");
			updateInhouseFleetResouce= properties.getProperty("UpdateInhouseFleet");
			getInhouseFleetResouce= properties.getProperty("GetInhouseFleet");
			deleteInhouseFleetResouce= properties.getProperty("DeleteInhouseFleet");
			inhouseFleetInquiryResouce= properties.getProperty("InhouseFleetInquiry");
			inhouseFleetEquipmentInquiryResource= properties.getProperty("InhouseFleetequipmentInquiry");
			requestPayloadAuthToken=properties.getProperty("RequestPayloadAuthToken");
			custNo = properties.getProperty("CustomerNumber");
			custName = properties.getProperty("CustomerName");
			requestingId= properties.getProperty("RequestingId");
			kcsmdb = properties.getProperty("KCSMECSDB");
			kcsrdb = properties.getProperty("KCSRECSDB");
			inhouseFleetName = properties.getProperty("InHouseFleetName");
			effectiveDate= properties.getProperty("EffectiveDate");
			expiryDate=properties.getProperty("ExpiryDate");
		}
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

}



