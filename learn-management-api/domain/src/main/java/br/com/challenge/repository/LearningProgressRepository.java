package br.com.challenge.repository;

import br.com.challenge.domain.Course;
import br.com.challenge.domain.LearningProgress;
import br.com.challenge.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LearningProgressRepository extends JpaRepository<LearningProgress, Long> {
    List<LearningProgress> findByStudentAndEndDateIsNull(Student student);
    List<LearningProgress> findByStudent_User_Username(String username);

}
