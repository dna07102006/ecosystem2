package com.nam.model.configuration;

import com.nam.model.organism.TrophicLevel;

import java.util.HashMap;
import java.util.Map;

public class OrganismConfiguration {
    private final TrophicLevel trophicLevel;
    private final double maxEnergy;
    private final double reproduceThreshold;
    private final int carryingCapacity;
    private final Map<Attribute<?>, Object> attributes = new HashMap<>();

    public OrganismConfiguration(TrophicLevel trophicLevel, double maxEnergy, double reproduceThreshold, int carryingCapacity) {
        this.trophicLevel = trophicLevel;
        this.maxEnergy = maxEnergy;
        this.reproduceThreshold = reproduceThreshold;
        this.carryingCapacity = carryingCapacity;
    }

    public <T> OrganismConfiguration set(Attribute<T> attr, T value) {
        attributes.put(attr, value);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Attribute<T> attr) throws IllegalArgumentException {
        if (!attributes.containsKey(attr)) {
            throw new IllegalArgumentException("No attribute " +  attr.getName() + " in this species");
        }
        return (T) attributes.get(attr);
    }

    public TrophicLevel getTrophicLevel() { return trophicLevel; }
    public double getMaxEnergy() { return maxEnergy; }
    public double getReproduceThreshold() { return reproduceThreshold; }
    public int getCarryingCapacity() { return carryingCapacity; }
}
