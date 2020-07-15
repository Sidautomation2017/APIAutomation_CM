package Pojo;

import java.util.List;

public class InhouseFleet_Inquiry {
	
	private List<CustomerNumbers> CustomerNumbers;
	private String organization;
	private String requestingUserID;
	private String connectingCarrierSCAC;
	
	public List<CustomerNumbers> getCustomerNumbers() {
		return CustomerNumbers;
	}
	public void setCustomerNumbers(List<Pojo.CustomerNumbers> customerNumbers) {
		this.CustomerNumbers = customerNumbers;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getRequestingUserID() {
		return requestingUserID;
	}
	public void setRequestingUserID(String requestingUserID) {
		this.requestingUserID = requestingUserID;
	}
	public String getConnectingCarrierSCAC() {
		return connectingCarrierSCAC;
	}
	public void setConnectingCarrierSCAC(String connectingCarrierSCAC) {
		this.connectingCarrierSCAC = connectingCarrierSCAC;
	}
	

}
