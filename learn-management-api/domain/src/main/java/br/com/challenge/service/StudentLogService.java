package br.com.challenge.service;

import br.com.challenge.domain.StudentLog;

import java.util.List;

public interface StudentLogService {
    void removeLog(Long learningProgressId, Long logId);

    StudentLog save(StudentLog studentLog);

    List<StudentLog> findByStudentUsername(String username);
}
