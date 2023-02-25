package com.tms.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private TruckModel truckModel;
    private LocalDate makeDate;
    private LocalDate technicalCheckExpirationDate;
    private double truckWeight;
    private int horsePower;
    private double fuelTankCapacity;

    public Truck(TruckModel truckModel, LocalDate makeDate, LocalDate technicalCheckExpirationDate, double truckWeight, int horsePower, double fuelTankCapacity) {
        this.truckModel = truckModel;
        this.makeDate = makeDate;
        this.technicalCheckExpirationDate = technicalCheckExpirationDate;
        this.truckWeight = truckWeight;
        this.horsePower = horsePower;
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public String toString() {
        return getTruckModel() + " " + getMakeDate() + " " + getTruckWeight() + "kg " + getHorsePower() + "HP " + getFuelTankCapacity() + "l.";
    }
}
