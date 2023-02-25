package com.tms.springboot.repository;

import com.tms.springboot.model.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckpointRepository extends JpaRepository<Checkpoint, Integer> {
}
