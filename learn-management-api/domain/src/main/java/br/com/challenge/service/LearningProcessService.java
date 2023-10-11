package br.com.challenge.service;

import br.com.challenge.domain.Course;
import br.com.challenge.domain.LearningProcess;
import br.com.challenge.domain.Student;

public interface LearningProcessService {
    LearningProcess enrollStudentInCourse(Student student, Course course);

    void leaveCourse(Student student, Course course);
}
