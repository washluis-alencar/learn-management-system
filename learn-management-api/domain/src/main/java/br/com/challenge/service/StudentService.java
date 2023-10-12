package br.com.challenge.service;

import br.com.challenge.domain.Student;

import java.util.Optional;

public interface StudentService {

    Student saveStudent(Student student);

    Student updateStudent(Long id, Student student);

    Optional<Student> findByUserName(String userName);
}
