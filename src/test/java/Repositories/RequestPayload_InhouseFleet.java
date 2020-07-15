package Repositories;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddUpdate_InhouseFleet;
import Pojo.CreateEquipmentOrder;
import Pojo.Create_InhouseFleet;
import Pojo.CustomerNumbers;
import Pojo.EquipmentsToAdd;
import Pojo.EquipmentsToDelete;
import Pojo.Get_InhouseFleet_Details;
import Pojo.InHouseFleetEquipment;
import Pojo.InhouseFleet_Inquiry;
import Pojo.OrderQuantity;
import Runner.InHouseFleet_TestCases;
import Utils.Configuration;
import Utils.DataBaseUtils;

public class RequestPayload_InhouseFleet {

	public static Create_InhouseFleet payload_createInhousefleet() {
		Create_InhouseFleet ci = new Create_InhouseFleet();
		ci.setCustomerNumber(Configuration.custNo);
		ci.setRequestingUserID(Configuration.custName);
		ci.setCustomerStationNumber("40000244");
		ci.setConnectingCarrierSCAC("KCS");
		ci.setEffectiveDate(DataBaseUtils.getInhouseEffecteveDate(Configuration.testEnv, Configuration.kcsmdb));
		ci.setExpiryDate("2999-12-31T11:22:00.003Z");
		ci.setFleetName(Configuration.inhouseFleetName);
		ci.setOrganization(Configuration.organization);
		InHouseFleetEquipment ihf = new InHouseFleetEquipment();
		ihf.setEquipmentInitial("A");
		ihf.setEquipmentNumber("100");
		List<InHouseFleetEquipment> list = new ArrayList<InHouseFleetEquipment>();
		list.add(ihf);
		ci.setInHouseFleetEquipment(list);
		return ci;

	}

	public static AddUpdate_InhouseFleet addUpdateInhouseFleetPayload() {
		
		AddUpdate_InhouseFleet adi = new AddUpdate_InhouseFleet();
		adi.setCustomerNumber(Configuration.custNo);
		adi.setRequestingUserID(Configuration.custName);
		adi.setCustomerStationNumber("40000244");
		adi.setConnectingCarrierSCAC("KCS");
		adi.setEffectiveDate(DataBaseUtils.getInhouseEffecteveDate(Configuration.testEnv, Configuration.kcsmdb));
		adi.setExpiryDate("2999-12-31T11:22:00.003Z");
		adi.setFleetName(Configuration.inhouseFleetName);
		adi.setOrganization(Configuration.organization);
		adi.setInHouseFleetIdentifier(InHouseFleet_TestCases.inhouseIdentifier);
		EquipmentsToAdd eta = new EquipmentsToAdd();
		EquipmentsToDelete etd = new EquipmentsToDelete();
		eta.setEquipmentInitial("SH");
		eta.setEquipmentNumber("124");
		etd.setEquipmentInitial("A");
		etd.setEquipmentNumber("100");
		List<EquipmentsToAdd> list_addeqp = new ArrayList<EquipmentsToAdd>();
		List<EquipmentsToDelete> list_deleteeqp = new ArrayList<EquipmentsToDelete>();
		list_addeqp.add(eta);
		list_deleteeqp.add(etd);
		adi.setEquipmentsToAdd(list_addeqp);
		adi.setEquipmentsToDelete(list_deleteeqp);
		return adi;
	}

	public static Get_InhouseFleet_Details payload_GetInhousefleetDeatils() {
		
		Get_InhouseFleet_Details gi = new Get_InhouseFleet_Details();
		gi.setCustomerNumber(Configuration.custNo);
		gi.setInHouseFleetIdentifier(InHouseFleet_TestCases.inhouseIdentifier);
		gi.setFleetName(Configuration.inhouseFleetName);
		gi.setOrganization(Configuration.organization);
		gi.setRequestingUserID(Configuration.requestingId);
		return gi;

	}
	
	public static InhouseFleet_Inquiry inhouseFleetEnquiry_Payload()
	{
		
		InhouseFleet_Inquiry ifi = new InhouseFleet_Inquiry();
		ifi.setConnectingCarrierSCAC("KCS");
		ifi.setOrganization(Configuration.organization);
		ifi.setRequestingUserID(Configuration.requestingId);
		 CustomerNumbers cn = new CustomerNumbers();
		 cn.setCustomerNumber(Configuration.custNo);
		 List<CustomerNumbers> list = new ArrayList<CustomerNumbers>();
		 list.add(cn);
		 ifi.setCustomerNumbers(list);
		return ifi;
		
	}

}
