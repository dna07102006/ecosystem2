package com.nam.scenario;

import com.nam.model.ecosystem.EcosystemImpl;
import com.nam.model.ecosystem.Position;
import com.nam.model.organism.OrganismFactory;

public abstract class AbstractScenario implements Scenario {
    private static final int ROWS = 30;
    private static final int COLS = 30;

    @Override
    public final EcosystemImpl load(OrganismFactory factory) {
        EcosystemImpl ecosystem = new EcosystemImpl(ROWS, COLS, factory);
        populate(ecosystem, factory, "grass", grassCount());
        populate(ecosystem, factory, "rabbit", rabbitCount());
        populate(ecosystem, factory, "wolf", wolfCount());
        return ecosystem;
    }

    protected abstract int grassCount();
    protected abstract int rabbitCount();
    protected abstract int wolfCount();

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
