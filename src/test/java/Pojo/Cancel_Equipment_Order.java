package Pojo;

public class Cancel_Equipment_Order {
	
	private int orderNumber;
	private String requestingUserID;
	private String customerNumber;
	private String organization;
	private String cancellationReasonCode;
	private String otherReason;
	
	
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
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getCancellationReasonCode() {
		return cancellationReasonCode;
	}
	public void setCancellationReasonCode(String cancellationReasonCode) {
		this.cancellationReasonCode = cancellationReasonCode;
	}
	public String getOtherReason() {
		return otherReason;
	}
	public void setOtherReason(String otherReason) {
		this.otherReason = otherReason;
	}

	

}
