package com.tms.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private CargoType cargoType;
    private String numberOfProducts;
    private String cargoWeight;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    public Cargo(CargoType cargoType, String numberOfProducts, String cargoWeight, DeliveryStatus deliveryStatus) {
        this.cargoType = cargoType;
        this.numberOfProducts = numberOfProducts;
        this.cargoWeight = cargoWeight;
        this.deliveryStatus = deliveryStatus;
    }

    @Override
    public String toString() {
        return getCargoType() + " " + getNumberOfProducts() + "qty. " + getCargoWeight() + "kg. " + getDeliveryStatus();
    }
}
