package com.tms.springboot.controller;

import com.tms.springboot.model.Destination;
import com.tms.springboot.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping(value = "/allDestinations")
    public Iterable<Destination> findAllDestination() {
        return destinationService.viewAllDestinations();
    }

    @GetMapping(value = "/findDestinationById/{id}")
    public Destination findDestinationById(@PathVariable int id) {
        var destination = destinationService.getDestinationById(id);
        if (destination == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return destination;
    }

    @PostMapping(value = "/createDestination")
    public Destination createDestination(@RequestBody Destination destination) {
        return destinationService.createDestination(destination);
    }

    @PutMapping(value = "/updateDestination")
    public Destination updateDestination(@RequestBody Destination destination) {
        var existingDestination = destinationService.updateDestination(destination);
        if (existingDestination == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return existingDestination;
    }

    @DeleteMapping(value = "/removeDestination/{id}")
    public void deleteDestination(@PathVariable int id) {
        var destination = destinationService.getDestinationById(id);
        if (destination == null)
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
        destinationService.deleteDestination(id);
    }
}
