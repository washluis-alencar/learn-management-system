package br.com.challenge.mapper;

import br.com.challenge.domain.Student;
import br.com.challenge.domain.User;
import br.com.challenge.presentation.representation.StudentRepresentation;

public class StudentMapper {

    public static Student mapperToStudent(StudentRepresentation representation) {
        Student student = new Student();
        student.setId(representation.getId());
        student.setDateOfBirth(representation.getDateOfBirth());
        student.setAddress(representation.getAddress());
        student.setEmail(representation.getEmail());
        student.setPhoneNumber(representation.getPhoneNumber());

        User user = new User();
        user.setUsername(representation.getUsername());
        user.setFirstName(representation.getFirstName());
        user.setLastName(representation.getLastName());
        student.setUser(user);

        return student;
    }

}
