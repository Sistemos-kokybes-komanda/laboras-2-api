package com.tms.springboot.controller;

import com.tms.springboot.model.Driver;
import com.tms.springboot.model.Manager;
import com.tms.springboot.service.DriverService;
import com.tms.springboot.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private DriverService driverService;

    @GetMapping(value = "/allManagers")
    public Iterable<Manager> findAllManagers() {
        return managerService.viewAllManagers();
    }

    @GetMapping(value = "/allDrivers")
    public Iterable<Driver> findAllDriver() {
        return driverService.viewAllDriver();
    }

    @GetMapping(value = "/findManagerById/{id}")
    public Manager findManagerById(@PathVariable int id) {
        var manager = managerService.getManagerById(id);
        if (manager == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return manager;
    }

    @GetMapping(value = "/findDriverById/{id}")
    public Driver findDriverById(@PathVariable int id) {
        var driver = driverService.getDriverById(id);
        if (driver == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return driver;
    }

    @PostMapping(value = "/validateManager")
    public Manager validateManager(@RequestBody String credentials) {
        return managerService.getManagerByLoginNameAndPassword(credentials);
    }

    @PostMapping(value = "/validateDriver")
    public Driver validateDriver(@RequestBody String credentials) {
        return driverService.getDriverByLoginNameAndPassword(credentials);
    }

    @PostMapping(value = "/createManager")
    public Manager createManager(@RequestBody Manager manager) {
        return managerService.createManager(manager);
    }

    @PostMapping(value = "/createDriver")
    public Driver createDriver(@RequestBody Driver driver) {
        return driverService.createDriver(driver);
    }

    @PutMapping(value = "/updateManager")
    public Manager updateManager(@RequestBody Manager manager) {
        var existingManager = managerService.updateManager(manager);
        if (existingManager == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return existingManager;
    }

    @PutMapping(value = "/updateDriver")
    public Driver updateDriver(@RequestBody Driver driver) {
        var existingDriver = driverService.updateDriver(driver);
        if (existingDriver == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return existingDriver;
    }

    @DeleteMapping(value = "/removeManager/{id}")
    public void deleteManager(@PathVariable int id) {
        var manager = managerService.getManagerById(id);
        if (manager == null)
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
        managerService.deleteManager(id);
    }

    @DeleteMapping(value = "/removeDriver/{id}")
    public void deleteDriver(@PathVariable int id) {
        var driver = driverService.getDriverById(id);
        if (driver == null)
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
        driverService.deleteDriver(id);
    }
}
