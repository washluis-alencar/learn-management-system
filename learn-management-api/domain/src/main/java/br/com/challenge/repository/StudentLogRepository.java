package br.com.challenge.repository;

import br.com.challenge.domain.StudentLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentLogRepository extends JpaRepository<StudentLog, Long> {

    List<StudentLog> findByLearningProgress_Student_User_Username(String username);
}
