package com.nam.model.organism;

import com.nam.model.ecosystem.Ecosystem;

public class Metabolize implements Behavior {
    @Override
    public void behave(Organism self, Ecosystem environment) {
        double rate = self.getConfiguration().get(Attributes.ENERGY_LOSS_RATE);
        self.loseEnergy(rate);
    }
}
