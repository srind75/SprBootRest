package com.example.boot.exceptions;

public class StudentNotFoundException extends RuntimeException {
 
    public StudentNotFoundException() {
        super("Student does not exist");
    }
    
    public StudentNotFoundException(String message) {
        super(message);
    }
}
