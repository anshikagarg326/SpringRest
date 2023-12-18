package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;


@RestController
public class MyController {
	
	@Autowired  //we need to create object to call that class so we'll use autowired annotation here
	private CourseService courseService; //created variable of type 'interface'
	
	@GetMapping("/home")
	public String home() {
		return "this is Anshika";
	}

	
	//GET THE COURSES
	@GetMapping("/courses") //but controller doesn't have  all the courses(or information) so it'll need service layer so we'll create an interface (along with class)named as CourseService
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	
	//single course get
	@GetMapping("/courses/{courseId}") //but controller doesn't have  all the courses(or information) so it'll need service layer so we'll create an interface (along with class)named as CourseService
	public Course getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));//it is coming in string so convert to long
	}
	
	//add a course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)//we need object in this case so 'course' of type 'Course'
	{
		return this.courseService.addCourse(course);
	}
	
	//update course using PUT request
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course)
	{
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}") 
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e ){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
