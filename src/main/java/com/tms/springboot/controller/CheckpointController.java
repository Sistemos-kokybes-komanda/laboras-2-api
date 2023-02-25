package com.tms.springboot.controller;

import com.tms.springboot.model.Checkpoint;
import com.tms.springboot.service.CheckpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CheckpointController {

    @Autowired
    private CheckpointService checkpointService;

    @GetMapping(value = "/allCheckpoints")
    public Iterable<Checkpoint> findAllCheckpoint() {
        return checkpointService.viewAllCheckpoint();
    }

    @GetMapping(value = "/findCheckpointById/{id}")
    public Checkpoint findCargoById(@PathVariable int id) {
        var checkpoint = checkpointService.getCheckpointById(id);
        if (checkpoint == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return checkpoint;
    }

    @PostMapping(value = "/createCheckpoint")
    public Checkpoint createCheckpoint(@RequestBody Checkpoint checkpoint) {
        return checkpointService.createCheckpoint(checkpoint);
    }

    @PutMapping(value = "/updateCheckpoint")
    public Checkpoint updateCheckpoint(@RequestBody Checkpoint checkpoint) {
        var existingCheckpoint = checkpointService.updateCheckpoint(checkpoint);
        if (existingCheckpoint == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return existingCheckpoint;
    }

    @DeleteMapping(value = "/removeCheckpoint/{id}")
    public void deleteCheckpoint(@PathVariable int id) {
        var checkpoint = checkpointService.getCheckpointById(id);
        if (checkpoint == null)
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
        checkpointService.deleteCheckpoint(id);
    }
}
