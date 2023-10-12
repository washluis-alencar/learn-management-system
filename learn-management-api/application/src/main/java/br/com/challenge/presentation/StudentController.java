package br.com.challenge.presentation;

import br.com.challenge.domain.Student;
import br.com.challenge.mapper.StudentMapper;
import br.com.challenge.presentation.representation.StudentRepresentation;
import br.com.challenge.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPath.STUDENTS)
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentRepresentation student) {
        return studentService.saveStudent(StudentMapper.mapperToStudent(student));
    }

}

