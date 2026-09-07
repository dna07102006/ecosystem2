package com.nam.model.configuration;

import java.util.List;
import com.nam.model.organism.TrophicLevel;
import lombok.Getter;

@Getter 
public class AnimalConfiguration extends OrganismConfiguration {
    private final double visionRange;
    private final double speed;
    private final double energyLossRate;
    private final List<String> food;

    protected AnimalConfiguration(TrophicLevel trophicLevel, double maxEnergy, double reproduceThreshold, int carryingCapacity, double visionRange, double speed, double energyLossRate, List<String> food) {
        super(trophicLevel, maxEnergy, reproduceThreshold, carryingCapacity);
        this.visionRange = visionRange;
        this.speed = speed; 
        this.energyLossRate = energyLossRate;
        this.food = food;
    }
}
