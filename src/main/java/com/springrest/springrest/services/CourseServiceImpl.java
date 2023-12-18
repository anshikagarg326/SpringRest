package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;


@Service //annotation to  tell that this is acting as the service layer
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao; //created variable of the Dao layer of type interface and it will make the object of the implementation class (autowired means automatic wiring)
	List<Course> list;
	
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(78,"huhuj","ahu"));
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll(); 
		//it'll pick all from the database and make an object and will add it to the list and return
	}
	
	@Override
	public Course getCourse(long courseId) {
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course);  // save method is used in both add and update course ,if there's a course present.it;ll update it , if not then it'll add that course
		return course;
	}
	
	@Override
	public void deleteCourse(long var) {
		Course entityvar=courseDao.getOne(var); //get the entity
		courseDao.delete(entityvar); //delete that entity
	}
}
