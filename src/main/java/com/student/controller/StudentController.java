package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.student.dao.StudentDao;
import com.student.dto.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDao studentdDao;
    
	//here we are receiving the base URL in request mapping.So,whenever we run our project the frontcontroller(webIntializer) will come and hit this method.
	//we have set a view for "home.jsp" so after th method is implemented it will redirect us to the "home.jsp" page.
	@RequestMapping("/")
	public ModelAndView homePage() {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("home.jsp");

		return modelandview;

	}

	@RequestMapping("/register")
	public ModelAndView registerstudent() {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("register.jsp");
		modelandview.addObject("student", new Student());

		return modelandview;
	}

	@RequestMapping("/save")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView modelandview = new ModelAndView();
		studentdDao.saveStudent(student);
		modelandview.setViewName("home.jsp");
		return modelandview;
	}
	
	@RequestMapping("/display")
	public ModelAndView displayStudents() {
		ModelAndView modelandview = new ModelAndView();  //ModelAndView modelandview = new ModelAndView("display.jsp"); insted of taking setview directly also take 
		modelandview.setViewName("display.jsp");
		modelandview.addObject("stud",studentdDao.findAllStudent());
		
		return modelandview;
	}
	
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam int id) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("update.jsp");
		modelAndView.addObject("studentupdate", studentdDao.findStudentById(id));
		return modelAndView;
	}
	
	@RequestMapping("/saveUpdateStudent")
	public ModelAndView saveUpdateStudent(@ModelAttribute Student updatestudent ) {
		ModelAndView modelAndView=new ModelAndView();
		studentdDao.updateStudent(updatestudent);
		
		modelAndView.setViewName("display.jsp");
		modelAndView.addObject("stud", studentdDao.findAllStudent());//this shoud be same in displays
		return modelAndView;
		
	}
	
	 @RequestMapping("/deleteStudent")
	 public ModelAndView deleteStudent(@RequestParam int id) {
		 ModelAndView modelAndView=new ModelAndView();
		Student student= studentdDao.findStudentById(id);
		studentdDao.deleteStudent(student);
		
		 modelAndView.setViewName("display.jsp");
		 modelAndView.addObject("stud", studentdDao.findAllStudent());
		 return modelAndView;
	 }
}
