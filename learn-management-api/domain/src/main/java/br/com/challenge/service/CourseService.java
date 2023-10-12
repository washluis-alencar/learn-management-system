package br.com.challenge.service;

import br.com.challenge.domain.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course, String adminUserName);

    List<Course> findAllCourses();
}
