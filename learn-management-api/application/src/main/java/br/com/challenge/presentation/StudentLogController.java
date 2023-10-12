package br.com.challenge.presentation;

import br.com.challenge.mapper.StudentLogMapper;
import br.com.challenge.presentation.representation.StudentLogRepresentation;
import br.com.challenge.service.StudentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ApiPath.STUDENT_LOG)
public class StudentLogController {

    private final StudentLogService studentLogService;

    @Autowired
    public StudentLogController(StudentLogService studentLogService) {
        this.studentLogService = studentLogService;
    }

    @PostMapping
    public StudentLogRepresentation saveStudentLog(@RequestBody StudentLogRepresentation representation) {
        var studentLog = studentLogService.save(StudentLogMapper.convertToStudentLog(representation));
        return StudentLogMapper.convertToRepresentation(studentLog);
    }

    @GetMapping(path = "/{studentUserName}")
    public List<StudentLogRepresentation> getAllLogsByStudent(@PathVariable String studentUserName) {
        var logList = studentLogService.findByStudentUsername(studentUserName);
        return logList.stream().map(StudentLogMapper::convertToRepresentation)
                .collect(Collectors.toList());
    }
}
