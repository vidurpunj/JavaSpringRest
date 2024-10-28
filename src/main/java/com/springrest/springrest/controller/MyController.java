package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "This is home pag of courses application";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		System.out.println("Get object id " + courseId);
		return this.courseService.getCourse(Integer.parseInt(courseId));
	}
	
	@PostMapping(path = "/courses", consumes = "application/json")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}

	// Update Course
	@PutMapping(path = "/courses/{courseid}", consumes = "application/json")
	public Course updateCourse(@RequestBody Course course, @PathVariable String courseId) {
		return this.courseService.updateCourse(course, Integer.parseInt(courseId));
	}
	
	// delete Course
	@DeleteMapping("/courses/{courseId}")
	public Course deleteCourse(@PathVariable String courseId) {
		return this.courseService.deleteCourse(Integer.parseInt(courseId));
	}
	
}
