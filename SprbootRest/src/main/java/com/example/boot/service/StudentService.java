package com.example.boot.service;

import java.util.Collection;

import com.example.boot.model.Student;

public interface StudentService {
	   public abstract void createStudent(Student student);
	   public abstract void updateStudent(String id, Student student);
	   public abstract void deleteStudent(String id);
	   public abstract Collection<Student> getStudents();
	  
}
