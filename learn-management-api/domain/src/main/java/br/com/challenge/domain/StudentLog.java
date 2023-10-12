package br.com.challenge.domain;

import br.com.challenge.enums.TaskCategory;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "STUDENT_LOG")
@Data
public class StudentLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private LearningProgress learningProgress;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private TaskCategory taskCategory;

    private String taskDescription;

    private Integer timeSpent;

    private boolean enabled = true;
}
