package com.example.boot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.boot.model.Student;
import com.example.boot.service.StudentServiceImpl;


//import com.example.springbootWebRest.service.StudentService;



@RestController
public class StudentController {

		
	@Autowired
	StudentServiceImpl studentServic;

	   @RequestMapping(value = "/students")
	   public ResponseEntity<Object> getStudent() {
	      return new ResponseEntity<>(studentServic.getStudents(), HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> 
	      updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
	      
		   studentServic.updateStudent(id, student);
	      return new ResponseEntity<>("Student is updated successsfully", HttpStatus.OK);
	   }
	   
	
	   @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		   studentServic.deleteStudent(id);
	      return new ResponseEntity<>("Student " + id +" is deleted successsfully", HttpStatus.OK);
	   }
	  
	   /*
	   @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> delete(@RequestBody Student student, @PathVariable("id") String id) {
		   studentServic.deleteStudent(id);
	      return new ResponseEntity<>("Student " + id +"  is deleted successsfully", HttpStatus.OK);
	   }
	    */
	   @RequestMapping(value = "/students", method = RequestMethod.POST)
	   public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		   studentServic.createStudent(student);
	      return new ResponseEntity<>("Student is created successfully", HttpStatus.CREATED);
	   }
	
}
