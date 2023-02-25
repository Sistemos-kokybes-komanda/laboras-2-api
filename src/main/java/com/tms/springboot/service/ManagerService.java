package com.tms.springboot.service;

import com.google.gson.Gson;
import com.tms.springboot.model.Manager;
import com.tms.springboot.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public Iterable<Manager> viewAllManagers() {
        return managerRepository.findAll();
    }

    public void deleteManager(int id) {
        managerRepository.deleteById(id);
    }

    public Manager updateManager(Manager manager) {
        Manager existingManager = managerRepository.findById(manager.getId()).orElse(null);
        if (existingManager == null)
            return null;
        existingManager.setLoginName(manager.getLoginName());
        existingManager.setPassword(manager.getPassword());
        existingManager.setName(manager.getName());
        existingManager.setSurname(manager.getSurname());
        existingManager.setEmail(manager.getEmail());
        existingManager.setPhoneNumber(manager.getPhoneNumber());
        existingManager.setDateOfBirth(manager.getDateOfBirth());
        existingManager.setCompanyName(manager.getCompanyName());
        return managerRepository.save(existingManager);
    }

    public Manager getManagerById(int id) {
        return managerRepository.findById(id).orElse(null);
    }

    public Manager getManagerByLoginNameAndPassword(String credentials) {
        Gson parser = new Gson();
        Properties properties = parser.fromJson(credentials, Properties.class);
        return managerRepository.findByLoginNameAndPassword(properties.getProperty("loginName"), properties.getProperty("password"));
    }
}
