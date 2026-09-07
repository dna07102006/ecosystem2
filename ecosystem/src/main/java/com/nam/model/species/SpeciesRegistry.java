package com.nam.model.species;

import java.util.HashMap;
import com.nam.model.configuration.ConfigurationRegistry;
import com.nam.model.organism.BehaviorRegistry;

public class SpeciesRegistry {
    private ConfigurationRegistry configRegistry = new ConfigurationRegistry();
    private BehaviorRegistry behaviorRegistry = new BehaviorRegistry();

    private HashMap<String, Species> species = new HashMap<>();
    
    public Species getSpecies(String speciesId) throws IllegalArgumentException {
        if (!species.containsKey(speciesId)) {
            Species name;

            switch (speciesId) {
                case "grass":
                    name = new Species("grass", configRegistry.getConfiguration("grass"), behaviorRegistry.getBehavior("grass"));
                    break;
                case "rabbit":
                    name = new Species("rabbit", configRegistry.getConfiguration("rabbit"), behaviorRegistry.getBehavior("rabbit"));
                    break;
                case "wolf":
                    name = new Species("wolf", configRegistry.getConfiguration("wolf"), behaviorRegistry.getBehavior("wolf"));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown species: " + speciesId);
            }
        }

        return species.get(speciesId);
    }
}
