package com.tms.springboot.service;

import com.tms.springboot.model.Destination;
import com.tms.springboot.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;

    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    public Iterable<Destination> viewAllDestinations() {
        return destinationRepository.findAll();
    }

    public void deleteDestination(int id) {
        destinationRepository.deleteById(id);
    }

    public Destination updateDestination(Destination destination) {
        Destination existingDestination = destinationRepository.findById(destination.getId()).orElse(null);
        if (existingDestination == null)
            return null;
        existingDestination.setStartLocation(destination.getStartLocation());
        existingDestination.setEndLocation(destination.getEndLocation());
        existingDestination.setStartDate(destination.getStartDate());
        existingDestination.setEndDate(destination.getEndDate());
        return destinationRepository.save(existingDestination);
    }

    public Destination getDestinationById(int id) {
        return destinationRepository.findById(id).orElse(null);
    }
}


