package com.jsp.studentcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.student.Student;
import com.jsp.studentservice.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping("/viewallstudent")
	public ModelAndView getAllStudent() {
		ModelAndView modalAndView = new ModelAndView("viewall.jsp");
		List<Student> student= studentService.getAllStudents();
		modalAndView.addObject("students" , student);
		return modalAndView;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateById() {
		ModelAndView modalAndView = new ModelAndView("updatestudent.jsp");
		modalAndView.addObject("studentupdate", new Student());
		return modalAndView;
	}
	
	@RequestMapping("/updatestudent")
	public ModelAndView finalUpdate(@ModelAttribute Student student) {
		ModelAndView modalAndView = new ModelAndView("home.jsp");
		studentService.updateStudentById(student.getId(), student);
		modalAndView.addObject("saved",student.getId()+"has been updated");
		return modalAndView;
	}
	
	@RequestMapping("/delete")
		public ModelAndView deleteStudentById(@RequestParam(name="id")int id) {
		ModelAndView modelAndView=new ModelAndView("home.jsp");
		boolean res = studentService.deletedById(id);
		
		modelAndView.addObject("saved","Student with following id is deleted "+id);
		
			return modelAndView;
			
		}
	
	
	@RequestMapping("/createstudent")
	public ModelAndView createStudent() {
		
		ModelAndView modelAndView=new ModelAndView("studentform.jsp");
		modelAndView.addObject("student1", new Student());
		return modelAndView;
	}
	@RequestMapping("/studentadd")
	public ModelAndView studentAdd(@ModelAttribute Student student) {
		ModelAndView modelAndView=new ModelAndView("home.jsp");
		studentService.saveStudent(student);
//		modelAndView.addObject("saved", student.getName() + " has been saved");
		return modelAndView;
	}
}
