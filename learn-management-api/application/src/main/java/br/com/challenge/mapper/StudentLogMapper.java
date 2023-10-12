package br.com.challenge.mapper;

import br.com.challenge.domain.LearningProgress;
import br.com.challenge.domain.StudentLog;
import br.com.challenge.presentation.representation.StudentLogRepresentation;

public class StudentLogMapper {

    public static StudentLog convertToStudentLog(StudentLogRepresentation representation) {
        StudentLog studentLog = new StudentLog();
        studentLog.setId(representation.getId());
        studentLog.setDate(representation.getDate());
        studentLog.setTaskCategory(representation.getTaskCategory());
        studentLog.setTaskDescription(representation.getTaskDescription());
        studentLog.setTimeSpent(representation.getTimeSpent());
        studentLog.setLearningProgress(new LearningProgress());
        studentLog.getLearningProgress().setId(representation.getLearningProgressId());
        return studentLog;
    }

    public static StudentLogRepresentation convertToRepresentation(StudentLog studentLog) {
        StudentLogRepresentation representation = new StudentLogRepresentation();
        representation.setId(studentLog.getId());
        representation.setDate(studentLog.getDate());
        representation.setTaskCategory(studentLog.getTaskCategory());
        representation.setTaskDescription(studentLog.getTaskDescription());
        representation.setTimeSpent(studentLog.getTimeSpent());
        representation.setLearningProgressId(studentLog.getLearningProgress().getId());
        return representation;
    }
}
