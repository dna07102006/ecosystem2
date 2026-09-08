package com.nam.model.organism;

import com.nam.model.configuration.OrganismConfiguration;
import com.nam.model.ecosystem.Ecosystem;
import com.nam.model.species.Species;

public class Organism{
    private double energy;
    private Species species;

    protected Organism(double energy, Species species) {
        this.energy = energy;
        this.species = species;
    }

    public void act(Ecosystem environment) {
        for (Behavior behavior : species.getBehaviors()) {
            behavior.behave(this, environment);
        }
    }

    public String getName(){
        return species.getSpeciesId();
    }
    
    public boolean isAlive(){
        return energy > 0;
    }

    protected void setEnergy(double energy){
        energy += energy;
    }

    protected  Species getSpecies(){
        return species;
    }
}
