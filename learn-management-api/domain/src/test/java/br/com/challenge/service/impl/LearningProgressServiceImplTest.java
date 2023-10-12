package br.com.challenge.service.impl;

import br.com.challenge.domain.Course;
import br.com.challenge.domain.LearningProgress;
import br.com.challenge.domain.Student;
import br.com.challenge.exception.EntityNotFoundException;
import br.com.challenge.exception.ServiceException;
import br.com.challenge.repository.LearningProgressRepository;
import br.com.challenge.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class LearningProgressServiceImplTest {

    @InjectMocks
    private LearningProgressServiceImpl learningProgressService;

    @Mock
    private LearningProgressRepository learningProgressRepository;

    @Mock
    private StudentService studentService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEnrollStudentInCourseSuccess() throws EntityNotFoundException {
        String studentUserName = "student1";
        Student student = TemplateUtil.createValidStudent();
        Course course = TemplateUtil.createValidCourse();
        LearningProgress learningProgress = TemplateUtil.createValidLearningProgress(student, course);

        when(studentService.findByUserName(studentUserName)).thenReturn(Optional.of(student));
        when(learningProgressRepository.save(any(LearningProgress.class))).thenReturn(learningProgress);

        LearningProgress enrolledProgress = learningProgressService.enrollStudentInCourse(studentUserName, course);

        assertEquals(learningProgress, enrolledProgress);
    }

    @Test
    public void testEnrollStudentInCourseStudentNotFound() {
        String studentUserName = "student1";
        when(studentService.findByUserName(studentUserName)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> learningProgressService
                .enrollStudentInCourse(studentUserName, TemplateUtil.createValidCourse()));
        verify(learningProgressRepository, never()).save(any(LearningProgress.class));
    }

    @Test
    public void testEnrollStudentInCourseMaxCoursesReached() {
        String studentUserName = "student1";
        Student student =  TemplateUtil.createValidStudent();
        when(studentService.findByUserName(studentUserName)).thenReturn(Optional.of(student));
        when(learningProgressRepository.findByStudentAndEndDateIsNull(student)).thenReturn(createMaxCoursesList());

        assertThrows(ServiceException.class, () -> learningProgressService
                .enrollStudentInCourse(studentUserName, TemplateUtil.createValidCourse()));
        verify(learningProgressRepository, never()).save(any(LearningProgress.class));
    }

    private List<LearningProgress> createMaxCoursesList() {
        List<LearningProgress> learningProgressList = new ArrayList<>();
        for (int i = 0; i < LearningProgressServiceImpl.MAX_COURSES_AT_TIME; i++) {
            learningProgressList.add(new LearningProgress());
        }
        return learningProgressList;
    }
}
