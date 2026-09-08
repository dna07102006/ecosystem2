package com.nam.simulation;

import com.nam.model.ecosystem.EcosystemImpl;
import com.nam.model.organism.Organism;
import com.nam.model.organism.OrganismFactory;
import com.nam.scenario.Scenario;

public class SimulationEngine {
    private final EcosystemImpl ecosystem;
    private int tickCount = 0;

    public SimulationEngine(Scenario scenario, OrganismFactory factory) {
        this.ecosystem = scenario.load(factory);
    }

    public void tick() {
        tickCount++;
        for (Organism o : ecosystem.getAllOrganisms()) {
            if (o.isAlive()) o.act(ecosystem);
        }
        for (Organism o : ecosystem.getAllOrganisms()) {
            if (!o.isAlive()) ecosystem.remove(o);
        }
    }

    public EcosystemImpl getEcosystem() { return ecosystem; }
    public int getTickCount() { return tickCount; }
}
