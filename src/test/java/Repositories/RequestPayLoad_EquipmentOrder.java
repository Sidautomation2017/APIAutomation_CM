package Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Pojo.Cancel_Equipment_Order;
import Pojo.CreateEquipmentOrder;
import Pojo.DestinationRoute;
import Pojo.Edit_Equipment_Order;
import Pojo.GetOrderDetails;
import Pojo.OrderDate;
import Pojo.OrderQuantity;
import Pojo.listOfEqpOrder;
import Runner.EquipmentOrder_TestCases;
import Utils.Configuration;
import io.cucumber.java.sl.Ce;

public class RequestPayLoad_EquipmentOrder {

	public static CreateEquipmentOrder createOrderPayloadWithMandatoryFields(CreateEquipmentOrder object) {
		/*
		 * CreateEquipmentOrder ce = new CreateEquipmentOrder(); ce.setOrderNumber();
		 * ce.setRequestingUserID(Configuration.requestingId);
		 * ce.setCustomerName(Configuration.custName);
		 * ce.setCustomerNumber(Configuration.custNo); ce.setStcc("2042115");
		 * ce.setEquipmentTypeCode("C1"); ce.setCustomerCity("WESTVILLE");
		 * ce.setCustomerState("OK"); ce.setPhoneNumber("11234567890");
		 * ce.setCustomerEmail("test@ecs.com");
		 * ce.setOrganization(Configuration.organization); ArrayList<OrderQuantity> list
		 * = new ArrayList<OrderQuantity>(); OrderQuantity oq = new OrderQuantity();
		 * oq.setEquipmentDateRequiredOn("2020-07-30T11:22:00.003Z");
		 * oq.setEquipmentQuantity("100"); list.add(oq); ce.setOrderQuantity(list);
		 */
		return object;

	}

	public static CreateEquipmentOrder createOrderPayloadWithOptionalPrams(CreateEquipmentOrder object) {

		CreateEquipmentOrder ce = new CreateEquipmentOrder();
		ce.setOrderNumber(EquipmentOrder_TestCases.orderNo);
		ce.setRequestingUserID(Configuration.requestingId);
		ce.setCustomerName(Configuration.custName);
		ce.setCustomerNumber(Configuration.custNo);
		ce.setStcc("2042115");
		ce.setEquipmentTypeCode("C1");
		ce.setCustomerStationNumber("40000244");
		ce.setCustomerCity("WESTVILLE");
		ce.setCustomerState("OK");
		ce.setPhoneNumber("11234567890");
		ce.setCustomerEmail("test@ecs.com");
		ce.setOrganization(Configuration.organization);
		ce.setOfflineStation("40000244");
		ce.setOfflineStateCode("OK");
		ce.setPhoneExtension("2222");
		ce.setSpecialInstructions("API Automation Driven Test");
		ce.setGuaranteeProgram("");
		// Order Quantity is array of multiple subjson
		ArrayList<OrderQuantity> list = new ArrayList<OrderQuantity>();
		OrderQuantity oq = new OrderQuantity();
		oq.setEquipmentDateRequiredOn("2020-07-30T11:22:00.003Z");
		oq.setEquipmentQuantity("100");
		list.add(oq);
		ce.setOrderQuantity(list);
		// Destination route is array of multiple subjson
		ArrayList<DestinationRoute> list_route = new ArrayList<DestinationRoute>();
		DestinationRoute dr = new DestinationRoute();
		dr.setRouteSCAC("KCS");
		dr.setR260JunctionId("");
		dr.setSequenceNumber("1");
		dr.setDestinationStationNumber("1900415734");
		dr.setDestinationStateCode("NJ");
		list_route.add(dr);
		ce.setDestinationRoute(list_route);
		System.out.println("object payload is"+ce);
		return ce;

	}

	public static Edit_Equipment_Order editOrderRequestPayload() {
		Edit_Equipment_Order eo = new Edit_Equipment_Order();
		eo.setOrderNumber(EquipmentOrder_TestCases.orderNo);
		eo.setRequestingUserID(Configuration.requestingId);
		eo.setCustomerName(Configuration.custName);
		eo.setCustomerNumber(Configuration.custNo);
		eo.setStcc("2042115");
		eo.setEquipmentTypeCode("C1");
		eo.setCustomerStationNumber("40000244");
		eo.setCustomerCity("WESTVILLE");
		eo.setCustomerState("OK");
		eo.setPhoneNumber("11234567890");
		eo.setCustomerEmail("test@ecs.com");
		eo.setOrganization(Configuration.organization);
		eo.setOfflineStation("40000244");
		eo.setOfflineStateCode("OK");
		eo.setPhoneExtension("2222");
		eo.setSpecialInstructions("API Automation Driven Test");
		eo.setGuaranteeProgram(true);
		// Order Quantity is array of multiple subjson
		ArrayList<OrderQuantity> list = new ArrayList<OrderQuantity>();
		OrderQuantity oq = new OrderQuantity();
		oq.setEquipmentDateRequiredOn("2020-07-30T11:22:00.003Z");
		oq.setEquipmentQuantity("100");
		// Adding more car quanity on edit order
		oq.setEquipmentDateRequiredOn("2020-08-01T11:22:00.003Z");
		oq.setEquipmentQuantity("200");
		oq.setEquipmentDateRequiredOn("2020-08-02T11:22:00.003Z");
		oq.setEquipmentQuantity("300");
		list.add(oq);
		eo.setOrderQuantity(list);
		// Destination route is array of multiple subjson
		ArrayList<DestinationRoute> list_route = new ArrayList<DestinationRoute>();
		DestinationRoute dr = new DestinationRoute();
		dr.setRouteSCAC("KCS");
		dr.setR260JunctionId("");
		dr.setSequenceNumber("1");
		dr.setDestinationStationNumber("1900415734");
		dr.setDestinationStateCode("NJ");
		list_route.add(dr);
		eo.setDestinationRoute(list_route);
		return eo;

	}

	public static GetOrderDetails getOrderDetails() {
		GetOrderDetails gt = new GetOrderDetails();
		gt.setCustomerNumber(Configuration.custNo);
		gt.setOrderNumber(EquipmentOrder_TestCases.orderNo);
		gt.setRequestingUserID(Configuration.requestingId);
		gt.setOrganization(Configuration.organization);
		return gt;

	}

	public static listOfEqpOrder listOfEOWithOptionalParams() {
		listOfEqpOrder leo = new listOfEqpOrder();
		leo.setCustomerNumber(Configuration.custNo);
		leo.setEquipmentTypeCode("C1");
		leo.setOrderNumber(0);
		leo.setOrderStatus("Active");
		leo.setOrganization(Configuration.organization);
		OrderDate od = new OrderDate();
		od.setFromOrderDate("2020-01-01T11:22:00.003Z");
		od.setToOrderDate("2020-08-31T11:22:00.003Z");
		leo.setOrderDate(od);
		return leo;

	}

	public static listOfEqpOrder listOfEOWithMandatoryParams() {
		listOfEqpOrder leo = new listOfEqpOrder();
		leo.setCustomerNumber(Configuration.custNo);
		leo.setOrganization(Configuration.organization);
		return leo;

	}

	public static Cancel_Equipment_Order cancelEqpOrderWithOptionalParams() {
		Cancel_Equipment_Order ceo = new Cancel_Equipment_Order();
		ceo.setCustomerNumber(Configuration.custNo);
		ceo.setOrderNumber(EquipmentOrder_TestCases.orderNo);
		ceo.setOrganization(Configuration.organization);
		ceo.setRequestingUserID(Configuration.requestingId);
		ceo.setCancellationReasonCode("5");
		ceo.setOtherReason("Cancelling EO through API");
		return ceo;

	}

}
