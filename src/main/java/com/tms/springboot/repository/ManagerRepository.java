package com.tms.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.springboot.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Manager findByLoginNameAndPassword(String loginName, String password);
}
