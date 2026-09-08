package com.nam.model.organism;

import com.nam.model.ecosystem.Ecosystem;

public class Spawn implements Behavior {
    @Override 
    public void behave(Organism self, Ecosystem environment) {
        if (self.getEnergy() < self.getConfiguration().getReproduceThreshold()) return;
        self.loseEnergy(self.getEnergy() / 2);
        environment.spawnOffspringNear(self);
    }
}
