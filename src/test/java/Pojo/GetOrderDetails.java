package Pojo;

public class GetOrderDetails {
	
	private int orderNumber;
	private String customerNumber;
	private String requestingUserID;
	private String organization;
	
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
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
	

}
