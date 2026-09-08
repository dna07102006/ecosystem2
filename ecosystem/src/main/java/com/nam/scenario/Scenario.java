package com.nam.scenario;

import com.nam.model.ecosystem.EcosystemImpl;
import com.nam.model.organism.OrganismFactory;

public interface Scenario {
    EcosystemImpl load(OrganismFactory factory);
}
