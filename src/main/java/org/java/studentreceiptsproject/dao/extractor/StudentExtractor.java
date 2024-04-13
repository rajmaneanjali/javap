package org.java.studentreceiptsproject.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.java.studentreceiptsproject.model.StudentForm;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
@Component
public class StudentExtractor implements ResultSetExtractor<StudentForm>{

	@Override
	public StudentForm extractData(ResultSet rs) throws SQLException, DataAccessException {
		StudentForm sf= null;
		if(rs.next()) {
		sf= new StudentForm();
		sf.setSno(rs.getInt("sno"));
		sf.setSname(rs.getString("sname"));
		sf.setAge(rs.getInt("age"));
		
		}
		return sf;
	}

}
