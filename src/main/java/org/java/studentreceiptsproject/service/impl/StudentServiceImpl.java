package org.java.studentreceiptsproject.service.impl;

import java.util.List;

import org.java.studentreceiptsproject.dao.StudentDao;
import org.java.studentreceiptsproject.model.StudentForm;
import org.java.studentreceiptsproject.service.StudentService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{
	 private StudentDao studentDao;

	@Override
	public List<StudentForm> getStudentService() {
		List<StudentForm> studentList = studentDao.getStudentList();
		return studentList;
	}

	@Override
	public StudentForm getStudentBySnoService(int sno) {
		StudentForm studentList = studentDao.getStudentBySno(sno);
		return studentList;
	}

	@Override
	public void insertStudentService(StudentForm studentForm) {
		studentDao.insertStudent(studentForm);	
	}

	@Override
	public void updateStudentService(StudentForm studentForm) {
		studentDao.updateStudent(studentForm);
		
	}

	@Override
	public void deleteStudentService(int sno) {
		studentDao.deleteStudent(sno);
		
	}
	 
}
