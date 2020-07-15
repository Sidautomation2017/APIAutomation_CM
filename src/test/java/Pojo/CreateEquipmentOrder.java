package Pojo;

import java.util.List;

public class CreateEquipmentOrder {
	
	private int orderNumber;
	private String requestingUserID;
	private String customerName;
	private String customerNumber;
	private String stcc;
	private String equipmentTypeCode;
	private String customerCity;
	private String customerState;
	private String phoneNumber;
	private String customerEmail;
	private List<OrderQuantity> orderQuantity;
	private String offlineStation;
	private String offlineStateCode;
	private String connectingCarrierSCAC;
	private String customerStationNumber;
	private String phoneExtension;
	private List<DestinationRoute> destinationRoute;
	private String guaranteeProgram;
	private String specialInstructions;	
	private String organization;
	
	
	public String getOfflineStation() {
		return offlineStation;
	}
	public void setOfflineStation(String offlineStation) {
		this.offlineStation = offlineStation;
	}
	public String getOfflineStateCode() {
		return offlineStateCode;
	}
	public void setOfflineStateCode(String offlineStateCode) {
		this.offlineStateCode = offlineStateCode;
	}
	public String getConnectingCarrierSCAC() {
		return connectingCarrierSCAC;
	}
	public void setConnectingCarrierSCAC(String connectingCarrierSCAC) {
		this.connectingCarrierSCAC = connectingCarrierSCAC;
	}
	public String getCustomerStationNumber() {
		return customerStationNumber;
	}
	public void setCustomerStationNumber(String customerStationNumber) {
		this.customerStationNumber = customerStationNumber;
	}
	public String getPhoneExtension() {
		return phoneExtension;
	}
	public void setPhoneExtension(String phoneExtension) {
		this.phoneExtension = phoneExtension;
	}
	public List<DestinationRoute> getDestinationRoute() {
		return destinationRoute;
	}
	public void setDestinationRoute(List<DestinationRoute> destinationRoute) {
		this.destinationRoute = destinationRoute;
	}
	public String isGuaranteeProgram() {
		return guaranteeProgram;
	}
	public void setGuaranteeProgram(String b) {
		this.guaranteeProgram = b;
	}
	public String getSpecialInstructions() {
		return specialInstructions;
	}
	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}
	
	
	

	
	public List<OrderQuantity> getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(List<OrderQuantity> orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	

	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getRequestingUserID() {
		return requestingUserID;
	}
	public void setRequestingUserID(String requestingUserID) {
		this.requestingUserID = requestingUserID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getStcc() {
		return stcc;
	}
	public void setStcc(String stcc) {
		this.stcc = stcc;
	}
	public String getEquipmentTypeCode() {
		return equipmentTypeCode;
	}
	public void setEquipmentTypeCode(String equipmentTypeCode) {
		this.equipmentTypeCode = equipmentTypeCode;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public String getCustomerState() {
		return customerState;
	}
	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	


	

}
