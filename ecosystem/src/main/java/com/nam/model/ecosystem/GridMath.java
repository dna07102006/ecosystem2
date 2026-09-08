package com.nam.model.ecosystem;

final class GridMath {
    private GridMath() {}

    static double distance(Position a, Position b) {
        int dr = a.row() - b.row();
        int dc = a.col() - b.col();
        return Math.sqrt(dr * dr + dc * dc);
    }

    static boolean isAdjacent(Position a, Position b) {
        return Math.abs(a.row() - b.row()) <= 1 && Math.abs(a.col() - b.col()) <= 1 && !a.equals(b);
    }

    static Position stepOnce(Position from, Position to) {
        int row = from.row() + Integer.signum(to.row() - from.row());
        int col = from.col() + Integer.signum(to.col() - from.col());
        return new Position(row, col);
    }
}
