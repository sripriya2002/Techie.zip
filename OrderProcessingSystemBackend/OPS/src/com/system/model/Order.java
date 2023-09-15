package com.system.model;

import java.util.Date;
import java.util.List;


import com.system.util.orderStatus;


public class Order {
	private int orderId;
	private Date orderDate;
	private int customerId;
	private String customerShippingAddress;
	private int product_id;
	private float orderValue;
	private float shippingCost;
	private orderStatus status;
	

// Parameterized Constructor	
public Order(int orderId, java.sql.Date orderDate, int customerId, String customerShippingAddress, int product_id, float orderValue,
			float shippingCost, orderStatus status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.customerShippingAddress = customerShippingAddress;
		this.product_id = product_id;
		this.orderValue = orderValue;
		this.shippingCost = shippingCost;
		this.status = status;
	
	}
	
//	Getter and Setter Method
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerShippingAddress() {
		return customerShippingAddress;
	}

	public void setCustomerShippingAddress(String customerShippingAddress) {
		this.customerShippingAddress = customerShippingAddress;
	}

	public float getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(float orderValue) {
		this.orderValue = orderValue;
	}

	public float getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(float shippingCost) {
		this.shippingCost = shippingCost;
	}

	public orderStatus getStatus() {
		return status;
	}

	public void setStatus(orderStatus status) {
		this.status = status;
	}
	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

// toString Method
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
				+ ", customerShippingAddress=" + customerShippingAddress + ", orderValue=" + orderValue
				+ ", shippingCost=" + shippingCost + ", status=" + status
				+ "]";
	}


	
}
