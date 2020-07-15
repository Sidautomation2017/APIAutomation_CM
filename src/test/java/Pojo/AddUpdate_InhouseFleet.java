package Pojo;

import java.util.List;

public class AddUpdate_InhouseFleet {

	private String connectingCarrierSCAC;
	private String customerStationNumber;
	private String effectiveDate;
	private String expiryDate;
	private String customerNumber;
	private String requestingUserID;
	private String organization;
	private String fleetName;
	private List<EquipmentsToAdd> equipmentsToAdd;
	private List<EquipmentsToDelete> equipmentsToDelete;
	private int inHouseFleetIdentifier;

	public int getInHouseFleetIdentifier() {
		return inHouseFleetIdentifier;
	}

	public void setInHouseFleetIdentifier(int inHouseFleetIdentifier) {
		this.inHouseFleetIdentifier = inHouseFleetIdentifier;
	}

	public List<EquipmentsToAdd> getEquipmentsToAdd() {
		return equipmentsToAdd;
	}

	public void setEquipmentsToAdd(List<EquipmentsToAdd> equipmentsToAdd) {
		this.equipmentsToAdd = equipmentsToAdd;
	}

	public List<EquipmentsToDelete> getEquipmentsToDelete() {
		return equipmentsToDelete;
	}

	public void setEquipmentsToDelete(List<EquipmentsToDelete> equipmentsToDelete) {
		this.equipmentsToDelete = equipmentsToDelete;
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
}
