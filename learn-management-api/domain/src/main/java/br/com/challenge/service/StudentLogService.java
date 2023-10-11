package br.com.challenge.service;

import br.com.challenge.domain.Student;

public interface StudentLogService {
    void removeLog(Student student, Long logId);
}
