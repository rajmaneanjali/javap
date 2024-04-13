package org.java.studentreceiptsproject.service.impl;

import java.util.List;

import org.java.studentreceiptsproject.dao.ReceiptDao;
import org.java.studentreceiptsproject.model.ReceiptForm;
import org.java.studentreceiptsproject.service.ReceiptService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ReceiptServiceImpl implements ReceiptService{
	private ReceiptDao receiptDao;

	@Override
	public List<ReceiptForm> getReceiptService() {
		List<ReceiptForm> receiptList = receiptDao.getReceiptList();
		return receiptList;
	}

	@Override
	public ReceiptForm getReceiptByReceiptnoService(int receiptno) {
		ReceiptForm receiptList = receiptDao.getReceiptByReceiptno(receiptno);
		return receiptList;
	}

	@Override
	public void insertReceiptService(ReceiptForm receiptForm) {
		receiptDao.insertReceipt(receiptForm);
	}

	@Override
	public void updateReceiptService(ReceiptForm receiptForm) {
		receiptDao.updateReceipt(receiptForm);
		
	}

	@Override
	public void deleteReceiptService(int receiptno) {
		receiptDao.deleteReceipt(receiptno);
		
	}
	
}
