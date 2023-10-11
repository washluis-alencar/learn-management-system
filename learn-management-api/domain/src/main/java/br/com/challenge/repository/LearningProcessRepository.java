package br.com.challenge.repository;

import br.com.challenge.domain.Course;
import br.com.challenge.domain.LearningProcess;
import br.com.challenge.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LearningProcessRepository extends JpaRepository<LearningProcess, Long> {
    List<LearningProcess> findByStudentAndEndDateIsNull(Student student);

    Optional<LearningProcess> findByStudentAndCourse(Student student, Course course);
}
