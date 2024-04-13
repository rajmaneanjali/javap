package org.java.studentreceiptsproject.model;

import java.util.List;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ReceiptForm {
	@Id
	private int receiptno;
	private String receiptdate;
	private int receiptamount;
	private StudentForm studentForm;
	
	public ReceiptForm(int receiptno, String receiptdate, int receiptamount) {
		super();
		this.receiptno = receiptno;
		this.receiptdate = receiptdate;
		this.receiptamount = receiptamount;
		
	}

	
}
