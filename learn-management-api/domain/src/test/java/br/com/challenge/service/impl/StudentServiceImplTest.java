package br.com.challenge.service.impl;

import br.com.challenge.domain.Student;
import br.com.challenge.exception.ServiceException;
import br.com.challenge.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveStudentValid() {
        Student student =  TemplateUtil.createValidStudent();
        when(studentRepository.save(student)).thenReturn(student);

        Student savedStudent = studentService.saveStudent(student);

        assertEquals(student, savedStudent);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testSaveStudentInvalidAge() {
        Student student = createStudentWithAge(15);

        assertThrows(ServiceException.class, () -> studentService.saveStudent(student));
    }

    @Test
    public void testSaveStudentEmailInUse() {
        Student student =  TemplateUtil.createValidStudent();
        when(studentRepository.findByEmail(student.getEmail())).thenReturn(Optional.of(student));

        assertThrows(ServiceException.class, () -> studentService.saveStudent(student));
    }

    @Test
    public void testUpdateStudentExists() {
        Long id = 1L;
        Student student = TemplateUtil.createValidStudent();
        when(studentRepository.existsById(id)).thenReturn(true);
        when(studentRepository.save(student)).thenReturn(student);

        Student updatedStudent = studentService.updateStudent(id, student);

        assertEquals(student, updatedStudent);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testUpdateStudentNotExists() {
        Long id = 1L;
        Student student = TemplateUtil.createValidStudent();
        when(studentRepository.existsById(id)).thenReturn(false);

        Student updatedStudent = studentService.updateStudent(id, student);

        assertNull(updatedStudent);
        verify(studentRepository, never()).save(student);
    }

    private Student createStudentWithAge(int age) {
        Student student = new Student();
        student.setDateOfBirth(LocalDate.now().minusYears(age));
        return student;
    }
}
