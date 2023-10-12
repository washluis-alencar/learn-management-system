package br.com.challenge.service;

public interface AdministratorService {
    // Check if user is administrator by User.userName
    boolean isAdministrator(String userName);
}
