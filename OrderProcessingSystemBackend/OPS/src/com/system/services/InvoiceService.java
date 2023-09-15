package com.system.services;

import java.sql.SQLException;
import java.util.Date;

import com.system.exception.NoSuchInvoiceFound;
import com.system.model.Invoice;
import com.system.util.GSTType;
import com.system.util.InvoiceStatus;

public interface InvoiceService {
	public Invoice fetchInvoiceByOrderId(int id) throws SQLException, NoSuchInvoiceFound;
	public boolean addInvoice(Invoice invoice )throws SQLException;

}
