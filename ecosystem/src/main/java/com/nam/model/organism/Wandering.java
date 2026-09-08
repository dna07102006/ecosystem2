package com.nam.model.organism;

import java.util.List;

import com.nam.model.ecosystem.Ecosystem;

public class Wandering implements Behavior {
    @Override 
    public void behave(Organism self, Ecosystem environment) {
        List<String> food = self.getConfiguration().get(Attributes.FOOD);
        double visionRange = self.getConfiguration().get(Attributes.VISION_RANGE);

        boolean canSeeFood = environment.nearestMatchedOrganismInRange(self, visionRange,
                prey -> prey.isAlive() && food.contains(prey.getName()))
            .isPresent();

        if (canSeeFood) return;

        environment.moveToRandomEmptyNeighbor(self);
    }
}
