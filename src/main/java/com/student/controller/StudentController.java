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
    // after we click on "ADD Student" on "home.jsp" the request wwill be comming to this (?register) url and registerStudent() will be implemented
	//Model and object -> we have also added an object which will be sent to register.jsp page,IT is basically a null object(new Student()) which is having  a key("student").
	//we will recived the null object in the JSP file using the key we have set.
	@RequestMapping("/register")
	public ModelAndView registerstudent() {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("register.jsp");
		modelandview.addObject("student", new Student());

		return modelandview;
	}
   /** when we click on the register button after providing all the values to the null object
     in the "register.jsp ,it will come in search of "/save" url and savestudent() method will be excuted.
     
      in this method we have received that particular object with the help of @ModelAttribute annotation
      and saved inside the database using the studentDao.saveStudent(student) method
      VIEW - we have set a view for home.jsp here.So, after a student object is saved then it will return 
      back  to the Home Page.
      Model/Object - No object or model is added in the method**/
	@RequestMapping("/save")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView modelandview = new ModelAndView();
		studentdDao.saveStudent(student);
		modelandview.setViewName("home.jsp");
		return modelandview;
	}
	
	
	/** when we click on the "display student"  on the "home.jsp" page the request will come and hit 
	 * @requestMapping("/display") and displayStudents() method will be excuted.
	 * view- here we have set a view for "display.jsp" page. So, thet Particular JSp file will be rendered
	 * on the browser.
	 * Model/Object - we are also sending an list of student object using the method 
	 * (StudentDao.findAllStudent()), and setting a key for the list(Students). 
	 	  **/
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
	/**
	   From the "display.jsp" page when a requested is given to update any student then it is hitting this 
	   mapping and updateStudent() is implemented.
	   as we need an id in order to fetch the database So we  are receiving the(id) sent from the "display.jsp" page 
	   using an annotation called @requestParam
	   ->In this method we have set a view page .
	    Model/Object - we are also sending an list of student object using the method 
	 * (StudentDao.findAllStudentById()), and setting a key for the list(stud). 
	 **/
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
