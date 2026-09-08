package com.nam.model.organism;

import com.nam.model.configuration.Attributes;
import com.nam.model.ecosystem.Ecosystem;

import java.util.List;

public class Hunt implements Behavior {
    @Override 
    public void behave(Organism self, Ecosystem environment) {
        List<String> food = self.getConfiguration().get(Attributes.FOOD);
        double visionRange = self.getConfiguration().get(Attributes.VISION_RANGE);
        double speed = self.getConfiguration().get(Attributes.SPEED);

        environment.nearestMatchedOrganismInRange(self, visionRange,
                prey -> prey.isAlive() && food.contains(prey.getName()))
            .ifPresent(prey -> environment.moveToward(self, prey, speed));
    }
}
