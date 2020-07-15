package Pojo;

import java.util.List;

public class Get_InhouseFleet_Details {

	private String customerNumber;
	private String requestingUserID;
	private String organization;
	private String fleetName;
	private int inHouseFleetIdentifier;

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

	public int getInHouseFleetIdentifier() {
		return inHouseFleetIdentifier;
	}

	public void setInHouseFleetIdentifier(int inHouseFleetIdentifier) {
		this.inHouseFleetIdentifier = inHouseFleetIdentifier;
	}

}
