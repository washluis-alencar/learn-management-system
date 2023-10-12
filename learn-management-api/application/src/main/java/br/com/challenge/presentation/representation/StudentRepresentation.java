package br.com.challenge.presentation.representation;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentRepresentation {
    private Long id;
    private LocalDate dateOfBirth;
    private String address;
    private String email;
    private String phoneNumber;
    private String username;
    private String firstName;
    private String lastName;
}
