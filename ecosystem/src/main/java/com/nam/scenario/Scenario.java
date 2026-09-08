package com.nam.scenario;

import com.nam.model.ecosystem.EcosystemImpl;
import com.nam.model.organism.OrganismFactory;

public interface Scenario {
    String getName();
    
    EcosystemImpl load(OrganismFactory factory);
}
