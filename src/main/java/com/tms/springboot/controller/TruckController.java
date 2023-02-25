package com.tms.springboot.controller;

import com.tms.springboot.model.Truck;
import com.tms.springboot.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TruckController {

    @Autowired
    private TruckService truckService;

    @GetMapping(value = "/allTrucks")
    public Iterable<Truck> findAllTrucks() {
        return truckService.viewAllTrucks();
    }

    @GetMapping(value = "/findTruckById/{id}")
    public Truck findTruckById(@PathVariable int id) {
        var truck = truckService.getTruckById(id);
        if (truck == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return truck;
    }

    @PostMapping(value = "/createTruck")
    public Truck createTruck(@RequestBody Truck truck) {
        return truckService.createTruck(truck);
    }

    @PutMapping(value = "/updateTruck")
    public Truck updateTruck(@RequestBody Truck truck) {
        var existingTruck = truckService.updateTruck(truck);
        if (existingTruck == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return existingTruck;
    }

    @DeleteMapping(value = "/removeTruck/{id}")
    public void deleteTruck(@PathVariable int id) {
        var truck = truckService.getTruckById(id);
        if (truck == null)
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
        truckService.deleteTruck(id);
    }
}
