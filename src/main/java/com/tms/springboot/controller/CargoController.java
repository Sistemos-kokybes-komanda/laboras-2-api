package com.tms.springboot.controller;

import com.tms.springboot.model.Cargo;
import com.tms.springboot.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping(value = "/allCargo")
    public Iterable<Cargo> findAllCargo() {
        return cargoService.viewAllCargo();
    }

    @GetMapping(value = "/findCargoById/{id}")
    public Cargo findCargoById(@PathVariable int id) {
        var cargo = cargoService.getCargoById(id);
        if (cargo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return cargo;
    }

    @PostMapping(value = "/createCargo")
    public Cargo createCargo(@RequestBody Cargo cargo) {
        return cargoService.createCargo(cargo);
    }

    @PutMapping(value = "/updateCargo")
    public Cargo updateCargo(@RequestBody Cargo cargo) {
        var existingCargo = cargoService.updateCargo(cargo);
        if (existingCargo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return existingCargo;
    }

    @DeleteMapping(value = "/removeCargo/{id}")
    public void deleteCargo(@PathVariable int id) {
        var cargo = cargoService.getCargoById(id);
        if (cargo == null)
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
        cargoService.deleteCargo(id);
    }
}
