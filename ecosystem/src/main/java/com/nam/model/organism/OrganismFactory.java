package com.nam.model.organism;

import com.nam.model.species.Species;
import com.nam.model.species.SpeciesRegistry;

public class OrganismFactory {
    private final SpeciesRegistry speciesRegistry = new SpeciesRegistry();
    
    public Organism createOrganism(String speciesId) throws IllegalArgumentException {
        Species species = speciesRegistry.getSpecies(speciesId);
        double energy = species.getConfig().getMaxEnergy();

        return new Organism(energy, species);
    };
}
