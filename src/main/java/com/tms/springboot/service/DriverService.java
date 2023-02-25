package com.tms.springboot.service;

import com.google.gson.Gson;
import com.tms.springboot.model.Driver;
import com.tms.springboot.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Iterable<Driver> viewAllDriver() {
        return driverRepository.findAll();
    }

    public void deleteDriver(int id) {
        driverRepository.deleteById(id);
    }

    public Driver updateDriver(Driver driver) {
        Driver existingDriver = driverRepository.findById(driver.getId()).orElse(null);
        if (existingDriver == null)
            return null;
        existingDriver.setLoginName(driver.getLoginName());
        existingDriver.setPassword(driver.getPassword());
        existingDriver.setName(driver.getName());
        existingDriver.setSurname(driver.getSurname());
        existingDriver.setEmail(driver.getEmail());
        existingDriver.setPhoneNumber(driver.getPhoneNumber());
        existingDriver.setDateOfBirth(driver.getDateOfBirth());
        existingDriver.setDriverLicenceNumber(driver.getDriverLicenceNumber());
        return driverRepository.save(existingDriver);
    }

    public Driver getDriverById(int id) {
        return driverRepository.findById(id).orElse(null);
    }

    public Driver getDriverByLoginNameAndPassword(String credentials) {
        Gson parser = new Gson();
        Properties properties = parser.fromJson(credentials, Properties.class);
        return driverRepository.findByLoginNameAndPassword(properties.getProperty("loginName"), properties.getProperty("password"));
    }
}

