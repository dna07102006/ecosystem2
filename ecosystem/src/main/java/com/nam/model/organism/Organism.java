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

    protected double getEnergy() {
        return energy;
    }
    
    protected void gainEnergy(double amount) { 
        this.energy += amount; 
    }

    protected void loseEnergy(double amount) { 
        this.energy = Math.max(0, this.energy - amount); 
    }

    protected  Species getSpecies(){
        return species;
    }

    protected OrganismConfiguration getConfiguration() { 
        return species.getConfig();
    }
}
