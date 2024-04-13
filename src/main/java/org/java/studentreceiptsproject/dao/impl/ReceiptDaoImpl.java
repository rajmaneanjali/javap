package org.java.studentreceiptsproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.java.studentreceiptsproject.dao.ReceiptDao;
import org.java.studentreceiptsproject.dao.extractor.ReceiptExtractor;
import org.java.studentreceiptsproject.dao.extractor.ReceiptListExtractor;
import org.java.studentreceiptsproject.dao.extractor.StudentExtractor;
import org.java.studentreceiptsproject.dao.extractor.StudentListExtractor;
import org.java.studentreceiptsproject.model.ReceiptForm;

import org.java.studentreceiptsproject.model.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Repository
@Getter
@Setter
@AllArgsConstructor
public class ReceiptDaoImpl implements ReceiptDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ReceiptListExtractor receiptListExtractor;
	@Autowired
	private StudentListExtractor studentListExtractor;
	@Autowired
	private StudentExtractor studentExtractor;
	@Autowired
	private ReceiptExtractor receiptExtractor;

	@Override
	public List<ReceiptForm> getReceiptList() {
		List<ReceiptForm> receiptList = jdbcTemplate.query("SELECT * FROM receipt ",receiptListExtractor::extractData);
		for (ReceiptForm receiptForm : receiptList) {
			StudentForm sf= jdbcTemplate.query("SELECT * FROM students where sno=(SELECT sno from receipt where receiptno="+receiptForm.getReceiptno()+")", studentExtractor::extractData);
			receiptForm.setStudentForm(sf);
		}
		return receiptList;
	}

	@Override
	public ReceiptForm getReceiptByReceiptno(int receiptno) {
		ReceiptForm receiptList = jdbcTemplate.query("SELECT * FROM receipt where receiptno="+receiptno, receiptExtractor::extractData);
			StudentForm studentForm = jdbcTemplate.query("SELECT * FROM students where sno=(SELECT sno from receipt where receiptno="+receiptList.getReceiptno()+")", studentExtractor::extractData);
					
			receiptList.setStudentForm(studentForm);
			return receiptList;
	}

	@Override
	public void insertReceipt(ReceiptForm receiptForm) {
		String query= "insert into receipt values("+ receiptForm.getReceiptno()+",'"+ receiptForm.getReceiptdate()+"',"+ receiptForm.getReceiptamount()+","+ receiptForm.getStudentForm().getSno()+");";
		jdbcTemplate.update(query);
	}

	@Override
	public void updateReceipt(ReceiptForm receiptForm) {
		String query = "update receipt set receiptdate='"+ receiptForm.getReceiptdate()+"' , receiptamount= "+receiptForm.getReceiptamount()+", sno="+receiptForm.getStudentForm().getSno()+" where receiptno="+receiptForm.getReceiptno()+" ";
		jdbcTemplate.update(query);	
	}

	@Override
	public void deleteReceipt(int receiptno) {
		String query = "delete from receipt where receiptno="+receiptno;
		jdbcTemplate.update(query);
		
	}

	
}
