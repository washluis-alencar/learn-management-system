package br.com.challenge.service;

import br.com.challenge.domain.Course;

public interface CourseService {
    Course createCourse(Course course, String adminUserName);
}
