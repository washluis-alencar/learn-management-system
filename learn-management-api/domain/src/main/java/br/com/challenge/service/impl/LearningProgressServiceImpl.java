package br.com.challenge.service.impl;

import br.com.challenge.domain.Course;
import br.com.challenge.domain.LearningProgress;
import br.com.challenge.domain.Student;
import br.com.challenge.exception.EntityNotFoundException;
import br.com.challenge.exception.ServiceException;
import br.com.challenge.repository.LearningProgressRepository;
import br.com.challenge.service.LearningProgressService;
import br.com.challenge.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LearningProgressServiceImpl implements LearningProgressService {
    
    private final LearningProgressRepository learningProgressRepository;
    private final StudentService studentService;


    public LearningProgressServiceImpl(LearningProgressRepository learningProgressRepository, StudentService studentService) {
        this.learningProgressRepository = learningProgressRepository;
        this.studentService = studentService;
    }

    @Override
    @Transactional
    public LearningProgress enrollStudentInCourse(String studentUserName, Course course) throws EntityNotFoundException {
        Optional<Student> studentOptional = this.studentService.findByUserName(studentUserName);
        if (studentOptional.isEmpty()) {
            throw new EntityNotFoundException("Student not found");
        }

        Student student = studentOptional.get();
        if (!isStudentAllowedToRegisterMoreCourses(student)) {
            throw new ServiceException("Student cannot register more than 3 courses");
        }

        LearningProgress learningProgress = new LearningProgress();
        learningProgress.setStudent(student);
        learningProgress.setCourse(course);
        learningProgress.setStartDate(LocalDateTime.now());

        return learningProgressRepository.save(learningProgress);
    }

    @Override
    @Transactional
    public LearningProgress update(LearningProgress learningProgress) throws EntityNotFoundException {
        Optional<LearningProgress> learningProgressUpdate = learningProgressRepository.findById(learningProgress.getId());
        if (learningProgressUpdate.isPresent()) {
            learningProgress.setStudent(learningProgressUpdate.get().getStudent());
            return learningProgressRepository.save(learningProgress);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<LearningProgress> findByStudentUserName(String studentUserName) {
        return learningProgressRepository.findByStudent_User_Username(studentUserName);
    }

    public boolean isStudentAllowedToRegisterMoreCourses(Student student) {
        List<LearningProgress> activeLearningProgresses = learningProgressRepository.findByStudentAndEndDateIsNull(student);
        return activeLearningProgresses.size() < 3;
    }
}
