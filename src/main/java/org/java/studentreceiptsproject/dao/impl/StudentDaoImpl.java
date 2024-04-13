package org.java.studentreceiptsproject.dao.impl;

import java.util.List;

import org.java.studentreceiptsproject.dao.StudentDao;
import org.java.studentreceiptsproject.dao.extractor.StudentExtractor;
import org.java.studentreceiptsproject.dao.extractor.StudentListExtractor;
import org.java.studentreceiptsproject.model.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Repository

@AllArgsConstructor
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private StudentListExtractor studentListExtractor;
	
	private StudentExtractor studentExtractor;

	@Override
	public List<StudentForm> getStudentList() {
		List<StudentForm> studentList = jdbcTemplate.query("SELECT * FROM students",studentListExtractor::extractData);
		return studentList;
	}

	@Override
	public StudentForm getStudentBySno(int sno) {
		StudentForm studentList = jdbcTemplate.query("SELECT * FROM students where sno="+sno, studentExtractor::extractData);
		return studentList;
	}

	@Override
	public void insertStudent(StudentForm studentForm) {
		String query= "insert into students values("+studentForm.getSno()+", '"+studentForm.getSname()+"',"+ studentForm.getAge()+")";
		jdbcTemplate.update(query);
	}

	@Override
	public void updateStudent(StudentForm studentForm) {
		String query = "update  students set sname='"+studentForm.getSname()+"', age="+studentForm.getAge()+" where sno="+studentForm.getSno()+" ";
		jdbcTemplate.update(query);
	}

	@Override
	public void deleteStudent(int sno) {
		String query = " delete from students where sno=" + sno;
		jdbcTemplate.update(query);
		
	}

}
