package br.com.challenge.service.impl;

import br.com.challenge.domain.Course;
import br.com.challenge.domain.User;
import br.com.challenge.repository.CourseRepository;
import br.com.challenge.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Period;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public Course createCourse(Course course, User user) {
        if (courseRepository.existsByCourseName(course.getCourseName())) {
            throw new IllegalArgumentException("Course name must be unique");
        }

        if (!isAdministrator(user)) {
            throw new IllegalArgumentException("Only administrators can manage courses");
        }

        if (course.getStartDate().isAfter(course.getFinalDate())) {
            throw new IllegalArgumentException("Start date cannot be after the final date");
        }

        if (!isCourseCompletedWithinSixMonths(course)) {
            throw new IllegalArgumentException("Course must be completed within 6 months of the start date");
        }

        return courseRepository.save(course);
    }

    private boolean isAdministrator(User user) {
        return false;
    }

    public boolean isCourseCompletedWithinSixMonths(Course course) {
        Period period = Period.between(course.getStartDate(), course.getFinalDate());
        int months = period.getYears() * 12 + period.getMonths();
        return months <= 6;
    }

}
