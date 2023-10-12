package br.com.challenge.service.impl;

import br.com.challenge.domain.Course;
import br.com.challenge.repository.CourseRepository;
import br.com.challenge.service.AdministratorService;
import br.com.challenge.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Period;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final AdministratorService administratorService;

    public CourseServiceImpl(CourseRepository courseRepository, AdministratorService administratorService) {
        this.courseRepository = courseRepository;
        this.administratorService = administratorService;
    }

    @Override
    @Transactional
    public Course createCourse(Course course, String adminUserName) {
        if (courseRepository.existsByCourseName(course.getCourseName())) {
            throw new IllegalArgumentException("Course name must be unique");
        }

        if (!administratorService.isAdministrator(adminUserName)) {
            throw new IllegalArgumentException("Only administrators can manage courses");
        }

        if (course.getStartDate() != null && course.getStartDate().isAfter(course.getFinalDate())) {
            throw new IllegalArgumentException("Start date cannot be after the final date");
        }

        if (!isCourseCompletedWithinSixMonths(course)) {
            throw new IllegalArgumentException("Course must be completed within 6 months of the start date");
        }

        return courseRepository.save(course);
    }

    public boolean isCourseCompletedWithinSixMonths(Course course) {
        if (course.getStartDate() == null || course.getFinalDate() == null) {
            return true;
        }
        Period period = Period.between(course.getStartDate(), course.getFinalDate());
        int months = period.getYears() * 12 + period.getMonths();
        return months <= 6;
    }

}
