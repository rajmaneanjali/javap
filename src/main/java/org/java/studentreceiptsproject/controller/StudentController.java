package org.java.studentreceiptsproject.controller;

import java.net.http.HttpRequest;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.java.studentreceiptsproject.model.StudentForm;
import org.java.studentreceiptsproject.service.StudentService;
import org.java.studentreceiptsproject.util.security.admin.BaseResource;
import org.java.studentreceiptsproject.util.security.admin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("v1/admin/student1")
@AllArgsConstructor
@CrossOrigin("*")
public class StudentController extends BaseResource{
	@Autowired
	private StudentService studentService;
		
	@GetMapping
	List<StudentForm> getStudentController(@RequestHeader("access-token")String token , HttpServletRequest request )
	{
		User user= getUser(request);
		if(user==null) return null;
		List<StudentForm> studentList= studentService.getStudentService();
		return studentList;
	}
	
	@GetMapping ("/{sno}")
	public StudentForm getStudentBySnoController(@PathVariable(value="sno") int sno, @RequestHeader("access-token")String token , HttpServletRequest request)
	{
		
		StudentForm studentList= studentService.getStudentBySnoService(sno);
		return studentList;
	}
	
	@PostMapping
	public void insertStudentController(@RequestBody StudentForm studentForm , @RequestHeader("access-token")String token , HttpServletRequest request)
	{
		User user= getUser(request);
		if(user==null) return ;
		studentService.insertStudentService(studentForm);
	}
	
	@PutMapping
	public void updateStudentController(@RequestBody StudentForm studentForm , @RequestHeader("access-token")String token , HttpServletRequest request)
	{
		studentService.updateStudentService(studentForm);
	}
	
	@DeleteMapping("/{sno}")
	public void deleteStudentController(@PathVariable(value="sno") int sno, @RequestHeader("access-token")String token , HttpServletRequest request)
	{
		studentService.deleteStudentService(sno);
	}
}
