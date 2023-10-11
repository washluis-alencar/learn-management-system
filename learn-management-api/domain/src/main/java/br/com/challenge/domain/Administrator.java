package br.com.challenge.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADMINISTRATOR")
@Data
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
