package br.com.challenge.service.impl;

import br.com.challenge.domain.StudentLog;
import br.com.challenge.repository.StudentLogRepository;
import br.com.challenge.service.StudentLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentLogServiceImpl implements StudentLogService {

    private final StudentLogRepository logRepository;

    public StudentLogServiceImpl(StudentLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    @Transactional
    public void removeLog(Long learningProgressId, Long logId) {
        Optional<StudentLog> optionalLog = logRepository.findById(logId);

        if (optionalLog.isPresent()) {
            StudentLog log = optionalLog.get();

            if (log.getLearningProgress().getId().equals(learningProgressId)) {
                log.setEnabled(false);
                logRepository.save(log);
            }
        }

        throw new IllegalArgumentException("Log not found");
    }

}
