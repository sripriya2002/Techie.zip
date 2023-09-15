package com.system.services;

import java.sql.SQLException;
import java.util.Date;
import com.system.dao.InvoiceDao;
import com.system.exception.NoSuchInvoiceFound;
import com.system.model.Customer;
import com.system.model.Invoice;
import com.system.util.GSTType;
import com.system.util.InvoiceStatus;

public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceDao Dao;


	@Override
	public Invoice fetchInvoiceByOrderId(int id) throws SQLException, NoSuchInvoiceFound {
		return Dao.getInvoiceByOrderId(id);
	}

	@Override
	public boolean addInvoice(Invoice invoice) throws SQLException {
		return Dao.addInvoice(invoice);
	}


	

}
