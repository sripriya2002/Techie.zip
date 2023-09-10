package com.system.model;

public class Company {
	private String companyName;
	private String companyString;
	private String companyCity;
	private int companyGSTNumber;
	
//	Parameterized Constructor
	public Company(String companyName, String companyString, String companyCity, int companyGSTNumber) {
		super();
		this.companyName = companyName;
		this.companyString = companyString;
		this.companyCity = companyCity;
		this.companyGSTNumber = companyGSTNumber;
	}
	
//	Getter and Setters method
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyString() {
		return companyString;
	}
	public void setCompanyString(String companyString) {
		this.companyString = companyString;
	}
	public String getCompanyCity() {
		return companyCity;
	}
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}
	public int getCompanyGSTNumber() {
		return companyGSTNumber;
	}
	public void setCompanyGSTNumber(int companyGSTNumber) {
		this.companyGSTNumber = companyGSTNumber;
	}
	
//	toString Method
	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", companyString=" + companyString + ", companyCity="
				+ companyCity + ", companyGSTNumber=" + companyGSTNumber + "]";
	}

}
