package com.system.dao;

import java.sql.SQLException;
import java.util.Date;

import com.system.exception.NoSuchInvoiceFound;
import com.system.model.Invoice;
import com.system.util.GSTType;
import com.system.util.InvoiceStatus;

public interface InvoiceDao {
	public Invoice getInvoiceByOrderId(int id) throws SQLException, NoSuchInvoiceFound;
	public boolean addInvoice(Invoice invoice)throws SQLException;

}
