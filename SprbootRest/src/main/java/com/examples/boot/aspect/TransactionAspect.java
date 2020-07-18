package com.examples.boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.boot.model.Student;
//import com.examples.exceptions.InsufficientFundsException;

@Component("aspect") 
@Aspect
public class TransactionAspect {
	@Before("execution(* com.examples.boot.service.StudentService.*(..))") 
	public void before(JoinPoint jp) { 
		Object[] args = jp.getArgs(); 
		Student stu =  (Student) args[0];
		//Account acc = (Account) args[0]; 
		stu.getDob();
	//	System.out.println("Before Advice : Initial Balance :"+acc.getBalance()); 
		}
	
	@After("execution(* com.examples.service.TransactionService.*(..))")
	public void after(JoinPoint jp) { 
		Object[] args = jp.getArgs(); 
//		Account acc = (Account) args[0]; 
	//	System.out.println("After Advice : Total Balance :"+acc.getBalance()); 
		}
	
	@AfterReturning(pointcut="execution(* com.examples.service.TransactionService.*(..))",returning="result")
	public void afterReturning(JoinPoint jp, String result) {
		System.out.println("After Returning Advice: Transaction Status :"+result); 
		}
	
	@Around("execution(* com.examples.service.TransactionService.*(..))")
	public void around(ProceedingJoinPoint jp) {
		System.out.println("Around Advice : Before "+jp.getSignature().getName()+" Method Execution"); 
		String status = ""; 
		try { 
			status = (String)jp.proceed(); 
		 } catch (Throwable e) { 
			 e.printStackTrace(); 
			  } 
		 System.out.println("Around Advice : After "+jp.getSignature().getName()+" Method Execution"); 
		 System.out.println("Around Advice : Transaction Status :"+status); 
		  }
	
	//@AfterThrowing(pointcut="execution(* com.examples h .service.TransactionService.*(..))", 
	 //throwing="exception") 
	/*public void afterThrowing(JoinPoint jp, InsufficientFundsException exception) { 
		System.out.println("After Throwing Advice : "+exception.getClass().getName()+" In Transaction :"+exception.getMessage()); 
		 } */
	 }