package com.nam.model.species;

import com.nam.model.organism.BehaviorRegistry;
import com.nam.model.organism.ConfigurationRegistry;

import java.util.HashMap;

public class SpeciesRegistry {
    private ConfigurationRegistry configRegistry = new ConfigurationRegistry();
    private BehaviorRegistry behaviorRegistry = new BehaviorRegistry();

    private HashMap<String, Species> species = new HashMap<>();
    
    public Species get(String speciesId) throws IllegalArgumentException {
        if (!species.containsKey(speciesId)) {
            Species name;

            switch (speciesId) {
                case "grass":
                    name = new Species("grass", configRegistry.get("grass"), behaviorRegistry.get("grass"));
                    break;
                case "rabbit":
                    name = new Species("rabbit", configRegistry.get("rabbit"), behaviorRegistry.get("rabbit"));
                    break;
                case "wolf":
                    name = new Species("wolf", configRegistry.get("wolf"), behaviorRegistry.get("wolf"));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown species: " + speciesId);
            }

            species.put(speciesId, name);
        }

        return species.get(speciesId);
    }
}
