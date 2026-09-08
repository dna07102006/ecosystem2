package com.nam.model.organism;

import com.nam.model.configuration.Attributes;
import com.nam.model.ecosystem.Ecosystem;   

public class Photosynthesize implements Behavior {
    @Override 
    public void behave(Organism self, Ecosystem environment) {
        double rate = self.getConfiguration().get(Attributes.PHOTOSYNTHESIS_RATE);
        self.gainEnergy(rate);
    }
}
