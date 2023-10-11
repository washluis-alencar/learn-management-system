package br.com.challenge.service;

import br.com.challenge.domain.Course;
import br.com.challenge.domain.User;

public interface CourseService {
    Course createCourse(Course course, User user);
}
