package com.nam.model.configuration;

import java.util.HashMap;
import java.util.List;
import com.nam.model.organism.TrophicLevel;

public class ConfigurationRegistry {
    private HashMap<String, OrganismConfiguration> configs = new HashMap<>();

    public OrganismConfiguration getConfiguration(String speciesId) throws IllegalArgumentException {
        if (!configs.containsKey(speciesId)) {
            OrganismConfiguration config;

            switch (speciesId) {
                case "grass":
                    config = new ProducerConfiguration(TrophicLevel.PRODUCER, 20, 5, 200, 2);
                    break;
                case "rabbit":
                    config = new AnimalConfiguration(TrophicLevel.HERBIVORE, 100, 50, 10, 5, 2, 1, List.of("grass"));
                    break;
                case "wolf":
                    config = new AnimalConfiguration(TrophicLevel.CARNIVORE, 150, 75, 5, 10, 3, 2, List.of("rabbit"));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown species: " + speciesId);
            }
            
            configs.put(speciesId, config);
        }

        return configs.get(speciesId);
    }
}
