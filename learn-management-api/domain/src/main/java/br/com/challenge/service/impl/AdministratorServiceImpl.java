package br.com.challenge.service.impl;

import br.com.challenge.repository.AdministratorRepository;
import br.com.challenge.service.AdministratorService;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    private final AdministratorRepository administratorRepository;

    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public boolean isAdministrator(String userName) {
        return administratorRepository.findByUser_Username(userName).isPresent();
    }
}
