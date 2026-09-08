package com.nam.model.configuration;

import com.nam.model.organism.TrophicLevel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationRegistry {
    private final Map<String, OrganismConfiguration> configs = new HashMap<>();

    public OrganismConfiguration get(String speciesId) throws IllegalArgumentException {
        if (!configs.containsKey(speciesId)){
            OrganismConfiguration config;

            switch (speciesId) {
                case "grass":
                    config = new OrganismConfiguration(TrophicLevel.PRODUCER, 20, 40, 200)
                        .set(Attributes.PHOTOSYNTHESIS_RATE, 2.0);
                    break;
                case "rabbit": 
                    config = new OrganismConfiguration(TrophicLevel.HERBIVORE, 50, 100, 15)
                        .set(Attributes.VISION_RANGE, 6.0)
                        .set(Attributes.SPEED, 3.0)
                        .set(Attributes.ENERGY_LOSS_RATE, 1.5)
                        .set(Attributes.FOOD, List.of("grass"));
                    break;
                case "wolf":
                    config = new OrganismConfiguration(TrophicLevel.CARNIVORE, 50, 100, 15)
                    .set(Attributes.VISION_RANGE, 6.0)
                    .set(Attributes.SPEED, 3.0)
                    .set(Attributes.ENERGY_LOSS_RATE, 1.5)
                    .set(Attributes.FOOD, List.of("rabbit"));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown species: " + speciesId);
            }
            
            configs.put(speciesId, config);
        }

        return configs.get(speciesId);
    }
}
