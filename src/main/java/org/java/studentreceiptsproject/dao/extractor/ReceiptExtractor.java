package org.java.studentreceiptsproject.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.java.studentreceiptsproject.model.ReceiptForm;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
@Component
public class ReceiptExtractor implements ResultSetExtractor<ReceiptForm>{

	@Override
	public ReceiptForm extractData(ResultSet rs) throws SQLException, DataAccessException {
		ReceiptForm rf = null;
		if(rs.next())
		{
			rf= new ReceiptForm();
			rf.setReceiptno(rs.getInt("receiptno"));
			rf.setReceiptdate(rs.getString("receiptdate"));
			rf.setReceiptamount(rs.getInt("receiptamount"));
			
		}
		return rf;
	}
	
	
}
