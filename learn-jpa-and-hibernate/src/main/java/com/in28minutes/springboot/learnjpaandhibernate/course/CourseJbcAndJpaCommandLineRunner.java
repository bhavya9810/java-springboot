package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
@Component
public class CourseJbcAndJpaCommandLineRunner implements CommandLineRunner {
// for jdbc
//	@Autowired
//	private CourseJdbcRepository repository;

//for jpa
//	@Autowired
//	private CourseJpaRepository repository;

//for springdatajpa
@Autowired
private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
//  for jdbc and jpa		
//	repository.insert(new Course(1,"learn Azure Jpa!","in28minutes"));	
//	repository.insert(new Course(2,"learn AWS Jpa!","in28minutes"));	
//	repository.insert(new Course(3,"learn DevOps Jpa!","in28minutes"));
	
		
		//for sprigndata jpa
		repository.save(new Course(1,"learn Azure Jpa!","in28minutes"));	
		repository.save(new Course(2,"learn AWS Jpa!","in28minutes"));	
		repository.save(new Course(3,"learn DevOps Jpa!","in28minutes"));	
		repository.save(new Course(4,"learn microservices Jpa!","bhavya singh"));
	
	//  for jdbc and jpa
		//repository.deleteById(3);
		
		//for sprigndata jpa
		repository.deleteById(3l);
		

//	
//	System.out.println(repository.selectById(2));
//	System.out.println(repository.selectById(1));
	
	//  for jdbc and jpa
		
	//System.out.println(repository.findById(2));
	//System.out.println(repository.findById(1));
	
	//for sprigndata jpa
	
	System.out.println(repository.findById(2l));
	System.out.println(repository.findById(1l));
	
	
	
	System.out.println(repository.findAll());
	System.out.println(repository.count());
	System.out.println(repository.findByauthor("bhavya singh"));
	System.out.println(repository.findByauthor("in28minutes"));
	System.out.println(repository.findByName("learn microservices Jpa!"));
	}

}
