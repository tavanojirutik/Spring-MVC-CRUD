package com.jsp.studentservice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.student.Student;
import com.jsp.studentdao.StudentDao;
@Component
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public Student saveStudent(Student student) {
	return studentDao.saveStudent(student);	
	}
	
	public List<Student> getAllStudents(){
		return studentDao.getAllStudent();
		
	}
	public boolean deletedById(int id) {
		return studentDao.deleteStudentById(id);
	}
	
	public Student updateStudentById(int id , Student student) {
		Student s = studentDao.getStudentById(id);
		s.setName(s.getName());
		s.setEmail(s.getEmail());
		return studentDao.UpdateStudentById(s);
	}
}
