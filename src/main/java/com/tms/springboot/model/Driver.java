package com.tms.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Driver extends User {
    private String driverLicenceNumber;

    public Driver(String loginName, String password, String name, String surname, String email, String phoneNumber, LocalDate dateOfBirth, LocalDate registrationDate, String driverLicenceNumber) {
        super(loginName, password, name, surname, email, phoneNumber, dateOfBirth, registrationDate);
        this.driverLicenceNumber = driverLicenceNumber;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " " + getEmail() + " " + driverLicenceNumber;
    }
}


