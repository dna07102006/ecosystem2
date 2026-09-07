package com.nam.model.configuration;

import com.nam.model.organism.TrophicLevel;
import lombok.Getter;

@Getter 
public abstract class OrganismConfiguration {
    private static final double ENERGY_TRANSFER_RATE = 0.1;

    private final double maxEnergy;
    private final double reproduceThreshold;
    private final int carryingCapacity;
    private final TrophicLevel trophicLevel;

    protected OrganismConfiguration(TrophicLevel trophicLevel, double maxEnergy, double reproduceThreshold, int carryingCapacity) {
        this.trophicLevel = trophicLevel;
        this.maxEnergy = maxEnergy;
        this.reproduceThreshold = reproduceThreshold;
        this.carryingCapacity = carryingCapacity;
    }
}
