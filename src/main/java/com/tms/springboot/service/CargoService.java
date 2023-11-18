package com.tms.springboot.service;

import com.tms.springboot.model.Cargo;
import com.tms.springboot.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    public Cargo createCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public Iterable<Cargo> viewAllCargo() {
        return cargoRepository.findAll();
    }

    public void deleteCargo(int id) {
        cargoRepository.deleteById(id);
    }

    public Cargo updateCargo(Cargo cargo) {
        Cargo existingCargo = cargoRepository.findById(cargo.getId()).orElse(null);
        Cargo result = null;
        if (existingCargo != null) {
            existingCargo.setCargoType(cargo.getCargoType());
            existingCargo.setNumberOfProducts(cargo.getNumberOfProducts());
            existingCargo.setCargoWeight(cargo.getCargoWeight());
            existingCargo.setDeliveryStatus(cargo.getDeliveryStatus());
            result = cargoRepository.save(existingCargo);
        }
        return result;
    }

    public Cargo getCargoById(int id) {
        return cargoRepository.findById(id).orElse(null);
    }
}

