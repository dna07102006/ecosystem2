package com.nam.model.ecosystem;

import com.nam.model.organism.Organism;

public class Cell {
    private final Position position;
    private Organism occupant;

    public Cell(Position position) {
        this.position = position;
    }

    public Position getPosition() { return position; }
    public boolean isEmpty() { return occupant == null; }
    public Organism getOccupant() { return occupant; }
    public void setOccupant(Organism occupant) { this.occupant = occupant; }
}
