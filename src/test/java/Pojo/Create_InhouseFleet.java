package Pojo;

import java.util.List;

public class Create_InhouseFleet {

	private String connectingCarrierSCAC;
	private String customerStationNumber;
	private String effectiveDate;
	private String expiryDate;
	private String customerNumber;
	private String requestingUserID;
	private String organization;
	private String fleetName;
	private List<InHouseFleetEquipment> InHouseFleetEquipment;

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

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getRequestingUserID() {
		return requestingUserID;
	}

	public void setRequestingUserID(String requestingUserID) {
		this.requestingUserID = requestingUserID;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getFleetName() {
		return fleetName;
	}

	public void setFleetName(String fleetName) {
		this.fleetName = fleetName;
	}

	public List<InHouseFleetEquipment> getInHouseFleetEquipment() {
		return InHouseFleetEquipment;
	}

	public void setInHouseFleetEquipment(List<InHouseFleetEquipment> inHouseFleetEquipment) {
		InHouseFleetEquipment = inHouseFleetEquipment;
	}

}
