package com.nam.model.configuration;

import java.util.List;

public final class Attributes {
    public static final Attribute<Double> VISION_RANGE = Attribute.of("visionRange");
    public static final Attribute<Double> SPEED = Attribute.of("speed");
    public static final Attribute<Double> ENERGY_LOSS_RATE = Attribute.of("energyLossRate");
    public static final Attribute<Double> PHOTOSYNTHESIS_RATE = Attribute.of("photosynthesisRate");
    public static final Attribute<List<String>> FOOD = Attribute.of("food");

    private Attributes() {}
}
