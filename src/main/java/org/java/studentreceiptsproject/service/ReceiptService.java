package org.java.studentreceiptsproject.service;

import java.util.List;

import org.java.studentreceiptsproject.model.ReceiptForm;


public interface ReceiptService {
	List<ReceiptForm> getReceiptService();
	ReceiptForm getReceiptByReceiptnoService(int receiptno);
	void insertReceiptService(ReceiptForm receiptForm);
	void updateReceiptService(ReceiptForm receiptForm);
	void deleteReceiptService(int receiptno);
}
