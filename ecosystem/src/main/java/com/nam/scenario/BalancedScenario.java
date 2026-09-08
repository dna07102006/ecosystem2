package com.nam.scenario;

import com.nam.model.ecosystem.EcosystemImpl;
import com.nam.model.ecosystem.Position;
import com.nam.model.organism.OrganismFactory;

public class BalancedScenario implements Scenario {
    @Override
    public EcosystemImpl load(OrganismFactory factory) {
        EcosystemImpl ecosystem = new EcosystemImpl(20, 20, factory);
        populate(ecosystem, factory, "grass", 30);
        populate(ecosystem, factory, "rabbit", 10);
        populate(ecosystem, factory, "wolf", 3);
        return ecosystem;
    }

    private void populate(EcosystemImpl ecosystem, OrganismFactory factory, String speciesId, int count) {
        for (int i = 0; i < count; i++) {
            Position pos = randomFreePosition(ecosystem);
            ecosystem.placeAt(factory.createOrganism(speciesId), pos);
        }
    }

    private Position randomFreePosition(EcosystemImpl ecosystem) {
        Position pos;
        do {
            pos = new Position((int) (Math.random() * ecosystem.getRows()), (int) (Math.random() * ecosystem.getCols()));
        } while (!ecosystem.getCell(pos.row(), pos.col()).isEmpty());
        return pos;
    }
}
