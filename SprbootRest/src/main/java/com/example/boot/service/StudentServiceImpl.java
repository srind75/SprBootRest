package com.example.boot.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.boot.model.Student;



@Service
public class StudentServiceImpl implements StudentService {
	private static Map<String, Student> studentRepo = new HashMap<>();
	   static {
				   
		   Student ram = new Student();
		      ram.setId("1");
		      ram.setName("Ram");
		      ram.setAddr("Bng");
		      ram.setDob("1-1-1980");
		      studentRepo.put(ram.getId(), ram);

		      Student krish = new Student();
		      krish.setId("2");
		      krish.setName("Krish");
		      krish.setAddr("Hyd");
		      krish.setDob("1-1-1990");
		      studentRepo.put(krish.getId(), krish);
	   }

	@Override
	public void createStudent(Student student) {
		studentRepo.put(student.getId(), student);

	}

	@Override
	public void updateStudent(String id, Student student) {
		//studentRepo.remove(id);
		student.setId(id);
	      studentRepo.put(id, student);
	}

	@Override
	public void deleteStudent(String id) {
		
		if (studentRepo.containsKey("id")) {
            //key exists
            System.out.println("yes! - " + studentRepo.get("id"));
            studentRepo.remove(id);
        } else {
            //key does not exists
            System.out.println("Student " + id +"  does not exist");
        }
		
	//	studentRepo.remove(id);
		/*
		studentRepository.findById(id).orElseThrow(RuntimeException :: new);
		studentRepository.deleteById(id);
		*/

	}

	@Override
	public Collection<Student> getStudents() {
		return studentRepo.values();
	}
}
