package com.springrest.springrest.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;

	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(1, "Java", "This course is about Java"));
		list.add(new Course(2, "Ruby", "This course is about Ruby"));
		list.add(new Course(3, "Spring Boot", "This course is about Spring Boot"));

	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(int courseId) {
		Course c = null;
		for(Course course: list) {
			if(course.getId() == courseId) {
				c = course;
				break;
			}
		}
		System.out.println(c.toString());
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course courseArg, int courseId) {
		Course course = list.get(courseId);
		course.setTitle(courseArg.getTitle());
		course.setDescription(courseArg.getDescription());
		return course;
	}
	
	@Override
	public Course deleteCourse(int courseid) {
		System.out.println("Remove the course id" + courseid);
		Course c = list.remove(courseid);
		return c;
	}
}
