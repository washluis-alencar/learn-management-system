package br.com.challenge.service;

import br.com.challenge.domain.Student;

public interface StudentService {

    Student saveStudent(Student student);

    Student updateStudent(Long id, Student student);
}
