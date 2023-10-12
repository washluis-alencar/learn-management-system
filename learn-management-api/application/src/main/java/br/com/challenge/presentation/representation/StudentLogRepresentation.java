package br.com.challenge.presentation.representation;

import br.com.challenge.enums.TaskCategory;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentLogRepresentation {
    private Long id;

    private Long learningProgressId;

    private LocalDate date;

    private TaskCategory taskCategory;

    private String taskDescription;

    private Integer timeSpent;

}
