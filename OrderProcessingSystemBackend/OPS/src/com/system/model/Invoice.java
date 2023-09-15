package com.system.model;

import java.util.Date;
import java.util.Map;

import com.system.util.GSTType;
import com.system.util.InvoiceStatus;

public class Invoice {
	private int invoiceId;
	private Date invoiceDate;
	private int orderId;
	private int customerId;
	private int productId;
	private GSTType typeOfGST;
	private float totalInvoiceValue;
	private InvoiceStatus status;
	
// Parameterized Constructor
public Invoice(int invoiceId, Date invoiceDate, int orderId, int customerId, int productId, GSTType typeOfGST,
			float totalInvoiceValue, InvoiceStatus status) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		this.orderId = orderId;
		this.customerId = customerId;
		this.productId = productId;
		this.typeOfGST = typeOfGST;
		this.totalInvoiceValue = totalInvoiceValue;
		this.status = status;
	}
// Getter and Setter Method
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public java.sql.Date getInvoiceDate() {
		return (java.sql.Date) invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public GSTType getTypeOfGST() {
		return typeOfGST;
	}
	public void setTypeOfGST(GSTType typeOfGST) {
		this.typeOfGST = typeOfGST;
	}
	public float getTotalInvoiceValue() {
		return totalInvoiceValue;
	}
	public void setTotalInvoiceValue(float totalInvoiceValue) {
		this.totalInvoiceValue = totalInvoiceValue;
	}
	public InvoiceStatus getStatus() {
		return status;
	}
	
	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}
}
