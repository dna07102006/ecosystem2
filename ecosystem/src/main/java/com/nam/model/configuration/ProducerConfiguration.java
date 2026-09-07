package com.nam.model.configuration;

import com.nam.model.organism.TrophicLevel;
import lombok.Getter;

@Getter 
public class ProducerConfiguration extends OrganismConfiguration {
    private final double photosynthesisRate;

    protected ProducerConfiguration(TrophicLevel trophicLevel, double maxEnergy, double reproduceThreshold, int carryingCapacity, double photosynthesisRate) {
        super(trophicLevel, maxEnergy, reproduceThreshold, carryingCapacity);
        this.photosynthesisRate = photosynthesisRate;
    }
}
