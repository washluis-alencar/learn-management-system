package br.com.challenge.repository;

import br.com.challenge.domain.StudentLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLogRepository extends JpaRepository<StudentLog, Long> {
}
