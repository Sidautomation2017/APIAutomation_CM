package Pojo;

public class listOfEqpOrder {
	
	private int orderNumber;
	private String organization;
	private String customerNumber;
	private String orderStatus;
	private String equipmentTypeCode;
	private OrderDate OrderDate;
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getEquipmentTypeCode() {
		return equipmentTypeCode;
	}
	public void setEquipmentTypeCode(String equipmentTypeCode) {
		this.equipmentTypeCode = equipmentTypeCode;
	}
	public OrderDate getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(OrderDate orderDate) {
		OrderDate = orderDate;
	}

	
}
