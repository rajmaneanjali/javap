package org.java.studentreceiptsproject.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.java.studentreceiptsproject.model.ReceiptForm;
import org.java.studentreceiptsproject.model.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class ReceiptListExtractor implements ResultSetExtractor<List<ReceiptForm>>{
		
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private StudentForm studentForm;
		@Override
		public List<ReceiptForm> extractData(ResultSet rs) throws SQLException, DataAccessException {
			ArrayList<ReceiptForm> receiptList = new ArrayList<>();
			ReceiptForm rf= null;
			
			while(rs.next())
			{
				rf= new ReceiptForm();
				rf.setReceiptno(rs.getInt("receiptno"));
				rf.setReceiptdate(rs.getString("receiptdate"));
				rf.setReceiptamount(rs.getInt("receiptamount"));
				receiptList.add(rf);
			}
			
			return receiptList;
		}
		
}
