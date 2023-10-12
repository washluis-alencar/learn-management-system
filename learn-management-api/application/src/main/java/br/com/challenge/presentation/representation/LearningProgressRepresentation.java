package br.com.challenge.presentation.representation;

import br.com.challenge.domain.Course;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LearningProgressRepresentation {
    private Long id;
    private String studentUserName;
    private Course course;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
