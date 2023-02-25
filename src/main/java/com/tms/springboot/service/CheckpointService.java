package com.tms.springboot.service;

import com.tms.springboot.model.Checkpoint;
import com.tms.springboot.repository.CheckpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CheckpointService {

    @Autowired
    private CheckpointRepository checkpointRepository;

    public Checkpoint createCheckpoint(Checkpoint checkpoint) {
        return checkpointRepository.save(checkpoint);
    }

    public Iterable<Checkpoint> viewAllCheckpoint() {
        return checkpointRepository.findAll();
    }

    public void deleteCheckpoint(int id) {
        checkpointRepository.deleteById(id);
    }

    public Checkpoint updateCheckpoint(Checkpoint checkpoint) {
        Checkpoint existingCheckpoint = checkpointRepository.findById(checkpoint.getId()).orElse(null);
        if (existingCheckpoint == null)
            return null;
        existingCheckpoint.setCheckpointLocation(checkpoint.getCheckpointLocation());
        existingCheckpoint.setUsedAmountOfFuel(checkpoint.getUsedAmountOfFuel());
        existingCheckpoint.setCheckpointTime(LocalDateTime.now());
        return checkpointRepository.save(existingCheckpoint);
    }

    public Checkpoint getCheckpointById(int id) {
        return checkpointRepository.findById(id).orElse(null);
    }
}

