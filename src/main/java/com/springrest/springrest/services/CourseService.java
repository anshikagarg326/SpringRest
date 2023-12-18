package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses(); //abstract method

	public Course getCourse(long courseId); //to get the particular course from the id

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long var);

}
