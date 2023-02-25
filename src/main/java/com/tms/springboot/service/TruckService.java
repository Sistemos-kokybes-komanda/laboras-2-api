package com.tms.springboot.service;

import com.tms.springboot.model.Truck;
import com.tms.springboot.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruckService {
    @Autowired
    private TruckRepository truckRepository;

    public Truck createTruck(Truck truck) {
        return truckRepository.save(truck);
    }

    public Iterable<Truck> viewAllTrucks() {
        return truckRepository.findAll();
    }

    public void deleteTruck(int id) {
        truckRepository.deleteById(id);
    }

    public Truck updateTruck(Truck truck) {
        Truck existingTruck = truckRepository.findById(truck.getId()).orElse(null);
        if (existingTruck == null)
            return null;
        existingTruck.setTruckModel(truck.getTruckModel());
        existingTruck.setMakeDate(truck.getMakeDate());
        existingTruck.setTechnicalCheckExpirationDate(truck.getTechnicalCheckExpirationDate());
        existingTruck.setTruckWeight(truck.getTruckWeight());
        existingTruck.setHorsePower(truck.getHorsePower());
        existingTruck.setFuelTankCapacity(truck.getFuelTankCapacity());
        return truckRepository.save(existingTruck);
    }

    public Truck getTruckById(int id) {
        return truckRepository.findById(id).orElse(null);
    }
}
