package br.com.challenge.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER_INFO")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
}
