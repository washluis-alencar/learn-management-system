package br.com.challenge.service.impl;

import br.com.challenge.domain.Course;
import br.com.challenge.domain.LearningProcess;
import br.com.challenge.domain.Student;
import br.com.challenge.repository.LearningProcessRepository;
import br.com.challenge.service.LearningProcessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LearningProcessServiceImpl implements LearningProcessService {
    
    private final LearningProcessRepository learningProcessRepository;


    public LearningProcessServiceImpl(LearningProcessRepository learningProcessRepository) {
        this.learningProcessRepository = learningProcessRepository;
    }

    @Override
    @Transactional
    public LearningProcess enrollStudentInCourse(Student student, Course course) {
        if (!isStudentAllowedToRegisterMoreCourses(student)) {
            throw new IllegalArgumentException("Student cannot register more than 3 courses");
        }

        LearningProcess learningProcess = new LearningProcess();
        learningProcess.setStudent(student);
        learningProcess.setCourse(course);
        learningProcess.setStartDate(LocalDateTime.now());

        return learningProcessRepository.save(learningProcess);
    }

    @Override
    @Transactional
    public void leaveCourse(Student student, Course course) {
        Optional<LearningProcess> learningProcess = learningProcessRepository.findByStudentAndCourse(student, course);

        if (learningProcess.isPresent()) {
            learningProcess.get().setEndDate(LocalDateTime.now());
            learningProcessRepository.save(learningProcess.get());
        } else {
            throw new IllegalArgumentException("Student is not enrolled in this course");
        }
    }

    public boolean isStudentAllowedToRegisterMoreCourses(Student student) {
        List<LearningProcess> activeLearningProcesses = learningProcessRepository.findByStudentAndEndDateIsNull(student);
        return activeLearningProcesses.size() < 3;
    }
}
