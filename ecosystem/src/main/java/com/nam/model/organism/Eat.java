package com.nam.model.organism;

import java.util.List;
import java.util.Optional;

import com.nam.model.configuration.Attributes;
import com.nam.model.ecosystem.Ecosystem;

public class Eat implements Behavior {
    @Override 
    public void behave(Organism self, Ecosystem environment) {
        List<String> food = self.getConfiguration().get(Attributes.FOOD);

        Optional<Organism> prey = environment.adjacentOrganisms(self).stream()
            .filter(other -> other.isAlive() && food.contains(other.getName()))
            .findFirst();

        prey.ifPresent(p -> {
            self.gainEnergy(p.getEnergy() * self.getConfiguration().ENERGY_TRANSFER_RATE);
            p.loseEnergy(p.getEnergy());
            environment.remove(p);
        });
    }
}
