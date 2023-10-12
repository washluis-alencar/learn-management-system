package br.com.challenge.presentation.representation;

import br.com.challenge.domain.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class CourseRepresentation {
    private Long id;

    private String courseCode;

    private String courseName;

    private LocalDate startDate;

    private LocalDate finalDate;

    private String description;

    private String adminUserName;
}
