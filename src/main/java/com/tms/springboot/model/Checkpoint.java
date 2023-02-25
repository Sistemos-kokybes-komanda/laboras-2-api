package com.tms.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Checkpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String checkpointLocation;
    private String usedAmountOfFuel;
    private LocalDateTime checkpointTime = LocalDateTime.now();

    public Checkpoint(String checkpointLocation, String usedAmountOfFuel, LocalDateTime checkpointTime) {
        this.checkpointLocation = checkpointLocation;
        this.usedAmountOfFuel = usedAmountOfFuel;
        this.checkpointTime = checkpointTime;
    }

    @Override
    public String toString() {
        return getCheckpointLocation() + " " + getUsedAmountOfFuel() + "l. " + getCheckpointTime();
    }
}
