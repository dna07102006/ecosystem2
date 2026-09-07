package com.nam.model.species;

import java.util.List;
import com.nam.model.configuration.OrganismConfiguration;
import com.nam.model.organism.Behavior;
import lombok.Getter;

@Getter
public class Species {
    private final String speciesId;
    private final OrganismConfiguration config;
    private final List<Behavior> behaviors;

    protected Species(String speciesId, OrganismConfiguration config, List<Behavior> behaviors) {
        this.speciesId = speciesId;
        this.config = config;
        this.behaviors = behaviors;
    }
}
