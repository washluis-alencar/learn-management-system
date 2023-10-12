package br.com.challenge.service;

import br.com.challenge.domain.Course;
import br.com.challenge.domain.LearningProgress;
import br.com.challenge.exception.EntityNotFoundException;

import java.util.List;

public interface LearningProgressService {
    LearningProgress enrollStudentInCourse(String studentUserName, Course course) throws EntityNotFoundException;

    LearningProgress update(LearningProgress learningProgress) throws EntityNotFoundException;

    List<LearningProgress> findByStudentUserName(String studentUserName);
}
