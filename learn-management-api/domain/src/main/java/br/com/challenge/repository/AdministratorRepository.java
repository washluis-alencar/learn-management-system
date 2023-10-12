package br.com.challenge.repository;

import br.com.challenge.domain.Administrator;
import br.com.challenge.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Optional<Administrator> findByUser_Username(String userName);
}
