package br.com.challenge.presentation.representation;

import lombok.Data;

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
