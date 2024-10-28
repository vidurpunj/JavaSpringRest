package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;

public interface  CourseService {
	
	public List<Course> getCourses();
	
	public Course getCourse(int courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course, int courseId);
	
	public Course deleteCourse(int courseId);

}
