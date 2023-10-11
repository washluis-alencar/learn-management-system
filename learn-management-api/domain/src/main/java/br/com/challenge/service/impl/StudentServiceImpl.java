package br.com.challenge.service.impl;

import br.com.challenge.domain.Student;
import br.com.challenge.repository.StudentRepository;
import br.com.challenge.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        if (!isStudentAgeValid(student.getDateOfBirth())) {
            throw new IllegalArgumentException("Student must be at least 16 years old.");
        }

        if (isEmailAlreadyInUse(student.getEmail())) {
            throw new IllegalArgumentException("Email address is already in use.");
        }

        if (!areMandatoryFieldsProvided(student)) {
            throw new IllegalArgumentException("Required fields should be informed.");
        }

        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }

    private boolean isStudentAgeValid(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        int years = period.getYears();
        return years >= 16;
    }

    private boolean isEmailAlreadyInUse(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }

    private boolean areMandatoryFieldsProvided(Student student) {
        return student.getUser() != null &&
                student.getUser().getFirstName() != null &&
                student.getUser().getLastName() != null &&
                student.getDateOfBirth() != null &&
                student.getAddress() != null &&
                student.getEmail() != null &&
                student.getPhoneNumber() != null;
    }
}
