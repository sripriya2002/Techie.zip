package com.system.model;

public class Customer {
	private int customerId;
	private String customerUserName;
	private String customerGstNumber;
	private String customerAddress;
	private String customerCity;
	private String customerEmail;
	private String customerPhone;
	private String customerPinCode;
	
//	Parameterized Customer
	public Customer(int customerId, String customerUserName, String customerGstNumber, String customerAddress,
			String customerCity, String customerEmail, String customerPhone, String customerPinCode) {
		super();
		this.customerId = customerId;
		this.customerUserName = customerUserName;
		this.customerGstNumber = customerGstNumber;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerEmail = customerEmail;
		this.customerPhone =customerPhone ;
		this.customerPinCode = customerPinCode;
	}
	
// Getter and Setters Method
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	public String getCustomerGstNumber() {
		return customerGstNumber;
	}
	public void setCustomerGstNumber(String customerGstNumber) {
		this.customerGstNumber = customerGstNumber;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerPinCode() {
		return customerPinCode;
	}
	public void setCustomerPinCode(String customerPinCode) {
		this.customerPinCode = customerPinCode;
	}
	
	
//	toString Method
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerUserName=" + customerUserName + ", customerGstNumber="
				+ customerGstNumber + ", customerAddress=" + customerAddress + ", customerCity=" + customerCity
				+ ", customerEmail=" + customerEmail + ", customerPhone=" + customerPhone + ", customerPinCode="
				+ customerPinCode + "]";
	}
	

}
