package com.nam.model.ecosystem;

import com.nam.model.organism.Organism;
import com.nam.model.organism.OrganismFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class EcosystemImpl implements Ecosystem {
    private final Cell[][] grid;
    private final Map<Organism, Position> positionCache = new HashMap<>();
    private final OrganismFactory organismFactory;
    private final int rows, cols;

    public EcosystemImpl(int rows, int cols, OrganismFactory organismFactory) {
        this.rows = rows;
        this.cols = cols;
        this.organismFactory = organismFactory;
        this.grid = new Cell[rows][cols];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = new Cell(new Position(r, c));
    }

    public void placeAt(Organism o, Position position) {
        grid[position.row()][position.col()].setOccupant(o);
        positionCache.put(o, position);
    }

    @Override
    public List<Organism> getAllOrganisms() {
        return new ArrayList<>(positionCache.keySet());
    }

    @Override
    public List<Organism> adjacentOrganisms(Organism self) {
        Position myPosition = positionCache.get(self);
        List<Organism> result = new ArrayList<>();
        for (Cell neighbor : getNeighborCells(myPosition)) {
            if (!neighbor.isEmpty()) result.add(neighbor.getOccupant());
        }
        return result;
    }

    @Override
    public Optional<Organism> nearestMatchedOrganismInRange(Organism self, double range, Predicate<Organism> matches) {
        Position myPosition = positionCache.get(self);
        Organism nearest = null;
        double bestDist = Double.MAX_VALUE;

        for (Organism candidate : positionCache.keySet()) {
            if (candidate == self || !matches.test(candidate)) continue;
            double dist = GridMath.distance(myPosition, positionCache.get(candidate));
            if (dist <= range && dist < bestDist) {
                bestDist = dist;
                nearest = candidate;
            }
        }
        return Optional.ofNullable(nearest);
    }

    @Override
    public void moveToward(Organism self, Organism target, double speed) {
        Position current = positionCache.get(self);
        Position targetPosition = positionCache.get(target);
        int steps = Math.max(1, (int) speed);

        for (int i = 0; i < steps; i++) {
            if (GridMath.isAdjacent(current, targetPosition)) break;
            Position next = clampToBounds(GridMath.stepOnce(current, targetPosition));
            if (!grid[next.row()][next.col()].isEmpty()) break;
            current = next;
        }

        moveTo(self, current);
    }

    @Override
    public void moveToRandomEmptyNeighbor(Organism self) {
        Position myPosition = positionCache.get(self);
        List<Cell> emptyNeighbors = getNeighborCells(myPosition).stream().filter(Cell::isEmpty).toList();
        if (emptyNeighbors.isEmpty()) return;
        Cell chosen = emptyNeighbors.get((int) (Math.random() * emptyNeighbors.size()));
        moveTo(self, chosen.getPosition());
    }

    @Override
    public void remove(Organism self) {
        Position pos = positionCache.remove(self);
        if (pos != null) grid[pos.row()][pos.col()].setOccupant(null);
    }

    @Override
    public void spawnOffspringNear(Organism self) {
        Position parentPosition = positionCache.get(self);
        List<Cell> emptyNeighbors = getNeighborCells(parentPosition).stream().filter(Cell::isEmpty).toList();
        if (emptyNeighbors.isEmpty()) return;

        Cell chosen = emptyNeighbors.get((int) (Math.random() * emptyNeighbors.size()));
        Organism offspring = organismFactory.createOrganism(self.getName());
        placeAt(offspring, chosen.getPosition());
    }

    private void moveTo(Organism o, Position newPos) {
        Position oldPos = positionCache.get(o);
        if (oldPos != null) grid[oldPos.row()][oldPos.col()].setOccupant(null);
        if (grid[newPos.row()][newPos.col()].isEmpty()) {
            grid[newPos.row()][newPos.col()].setOccupant(o);
            positionCache.put(o, newPos);
        } else if (oldPos != null) {
            grid[oldPos.row()][oldPos.col()].setOccupant(o);
        }
    }

    private Position clampToBounds(Position p) {
        int row = Math.max(0, Math.min(rows - 1, p.row()));
        int col = Math.max(0, Math.min(cols - 1, p.col()));
        return new Position(row, col);
    }

    private List<Cell> getNeighborCells(Position p) {
        List<Cell> result = new ArrayList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] d : dirs) {
            int nr = p.row() + d[0], nc = p.col() + d[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) result.add(grid[nr][nc]);
        }
        return result;
    }

    public Cell getCell(int row, int col) { return grid[row][col]; }
    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public Position getPositionOf(Organism o) { return positionCache.get(o); }
}
