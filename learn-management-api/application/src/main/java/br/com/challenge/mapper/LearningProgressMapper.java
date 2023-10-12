package br.com.challenge.mapper;

import br.com.challenge.domain.LearningProgress;
import br.com.challenge.domain.Student;
import br.com.challenge.domain.User;
import br.com.challenge.presentation.representation.LearningProgressRepresentation;

public class LearningProgressMapper {

    public static LearningProgressRepresentation convertToRepresentation(LearningProgress learningProgress) {
        LearningProgressRepresentation representation = new LearningProgressRepresentation();
        representation.setId(learningProgress.getId());
        representation.setStudentUserName(learningProgress.getStudent().getUser().getUsername());
        representation.setCourse(learningProgress.getCourse());
        representation.setStartDate(learningProgress.getStartDate());
        representation.setEndDate(learningProgress.getEndDate());
        return representation;
    }

    public static LearningProgress convertToLearningProgress(LearningProgressRepresentation representation) {
        LearningProgress learningProgress = new LearningProgress();
        learningProgress.setId(representation.getId());
        Student student = new Student();
        student.setUser(new User());
        student.getUser().setUsername(representation.getStudentUserName());
        learningProgress.setStudent(student);
        learningProgress.setCourse(representation.getCourse());
        learningProgress.setStartDate(representation.getStartDate());
        learningProgress.setEndDate(representation.getEndDate());
        return learningProgress;
    }
}
