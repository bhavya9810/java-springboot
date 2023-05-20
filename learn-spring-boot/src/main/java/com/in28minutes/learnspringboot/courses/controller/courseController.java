package com.in28minutes.learnspringboot.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.learnspringboot.courses.bean.Course;
import com.in28minutes.learnspringboot.courses.repository.CourseRepository;

@RestController
public class courseController {
	@Autowired
	private CourseRepository repository;
	
	// http://localhost:8080/courses
	
	@GetMapping("/courses")
	public List<Course> getAllcourses(){
		
		
		return repository.findAll();
//		return Arrays.asList(new Course(1,"Learn Microservices","in28minutes"),
//				new Course(2,"Learn Full Stack with Angular and React","in28minutes")); 
	}
	
	
	
	// http://localhost:8080/courses/1
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable long id) {
		
        Optional<Course> course = repository.findById(id);
		if(course.isEmpty()) {
			throw new RuntimeException("course not found with id "+id);
		}
        
           return course.get();
		
		//return new Course(1,"Learn Full Stack with Angular and React and springboot","in28minutes");
	}

	
	
	@PostMapping("/courses")
    public void createCourse(@RequestBody Course course) {
		
		repository.save(course);
		
		
		
	}
	
	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable long id,@RequestBody Course course) {
		repository.save(course);
	}
	
	@DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable long id) {
		
		repository.deleteById(id);
	}
	}






//docker run --detach 
//--env MYSQL_ROOT_PASSWORD=dummypassword 
//--env MYSQL_USER=courses-user 
//--env MYSQL_PASSWORD=dummycourses 
//--env MYSQL_DATABASE=courses 
//--name mysql 
//--publish 3306:3306 mysql:5.7



