package com.tms.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.springboot.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    Driver findByLoginNameAndPassword(String loginName, String password);
}
