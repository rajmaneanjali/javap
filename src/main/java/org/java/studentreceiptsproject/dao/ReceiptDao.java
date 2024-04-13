package org.java.studentreceiptsproject.dao;

import java.util.List;

import org.java.studentreceiptsproject.model.ReceiptForm;



public interface ReceiptDao {
	List<ReceiptForm> getReceiptList();
	ReceiptForm getReceiptByReceiptno(int receiptno);
	void insertReceipt (ReceiptForm receiptForm);
	void updateReceipt(ReceiptForm receiptForm);
	void deleteReceipt(int receiptno);
}
