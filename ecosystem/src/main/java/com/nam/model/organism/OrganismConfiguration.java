package com.nam.model.organism;

import java.util.HashMap;
import java.util.Map;

public class OrganismConfiguration {
    public static final double ENERGY_TRANSFER_RATE = 0.1;

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
