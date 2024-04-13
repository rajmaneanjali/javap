package org.java.studentreceiptsproject.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.java.studentreceiptsproject.model.StudentForm;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class StudentListExtractor implements ResultSetExtractor<List<StudentForm>>{

	@Override
	public List<StudentForm> extractData(ResultSet rs) throws SQLException, DataAccessException {
		ArrayList<StudentForm> studentList = new ArrayList<>();
		StudentForm sf= null;
		
		while(rs.next())
		{
			sf = new StudentForm();
			sf.setSno(rs.getInt("sno"));
			sf.setSname(rs.getString("sname"));
			sf.setAge(rs.getInt("age"));
			studentList.add(sf);
		}
		return studentList;
	}
	
	
}
