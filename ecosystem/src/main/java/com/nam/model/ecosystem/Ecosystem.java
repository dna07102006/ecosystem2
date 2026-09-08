package com.nam.model.ecosystem;

import com.nam.model.organism.Organism;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Ecosystem {
    List<Organism> getAllOrganisms();
    List<Organism> adjacentOrganisms(Organism self);
    Optional<Organism> nearestMatchedOrganismInRange(Organism self, double visionRange, Predicate<Organism> matches);

    void moveToward(Organism self, Organism target, double speed);
    void moveToRandomEmptyNeighbor(Organism self);
    void remove(Organism self);
    void spawnOffspringNear(Organism self);
}
