package br.com.challenge.service.impl;

import br.com.challenge.domain.Course;
import br.com.challenge.domain.LearningProgress;
import br.com.challenge.domain.Student;
import br.com.challenge.domain.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TemplateUtil {

    public static Student createValidStudent() {
        Student student = new Student();
        student.setId(1L);
        student.setDateOfBirth(LocalDate.of(2000, 1, 1)); // 21 years old
        student.setEmail("test@example.com");
        student.setAddress("Test address");
        student.setPhoneNumber("123456789");
        student.setUser(new User());
        student.getUser().setId(1L);
        student.getUser().setUsername("test");
        student.getUser().setFirstName("Test");
        student.getUser().setLastName("Test");
        return student;
    }

    public static Course createValidCourse() {
        Course course = new Course();
        course.setId(1L);
        course.setCourseCode("123");
        course.setCourseName("Test course");
        course.setDescription("Test description");
        course.setStartDate(LocalDate.now());
        course.setFinalDate(LocalDate.now().plusMonths(1));
        return course;
    }

    public static LearningProgress createValidLearningProgress(Student student, Course course) {
        LearningProgress learningProgress = new LearningProgress();
        learningProgress.setId(1L);
        learningProgress.setStudent(student);
        learningProgress.setCourse(course);
        learningProgress.setStartDate(LocalDateTime.now());
        learningProgress.setEndDate(LocalDateTime.now().plusMonths(1));
        return learningProgress;
    }

}
