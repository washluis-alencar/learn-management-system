package br.com.challenge.service.impl;

import br.com.challenge.domain.StudentLog;
import br.com.challenge.repository.StudentLogRepository;
import br.com.challenge.service.StudentLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentLogServiceImpl implements StudentLogService {

    private final StudentLogRepository logRepository;

    public StudentLogServiceImpl(StudentLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    @Transactional
    public void removeLog(Long logId) {
        Optional<StudentLog> optionalLog = logRepository.findById(logId);

        if (optionalLog.isPresent()) {
            StudentLog log = optionalLog.get();
            log.setEnabled(false);
            logRepository.save(log);
        } else {
            throw new IllegalArgumentException("Log not found");
        }
    }

    @Override
    @Transactional
    public StudentLog save(StudentLog studentLog) {
        return logRepository.save(studentLog);
    }

    @Override
    public List<StudentLog> findByStudentUsername(String username) {
        return logRepository.findByEnabledTrueAndLearningProgress_Student_User_Username(username);
    }
}
