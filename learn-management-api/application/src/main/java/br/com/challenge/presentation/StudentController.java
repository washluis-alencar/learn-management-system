package br.com.challenge.presentation;

import br.com.challenge.domain.Student;
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
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

}

