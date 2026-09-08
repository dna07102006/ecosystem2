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

    static Position stepToward(Position from, Position to, double speed) {
        int steps = Math.max(1, (int) speed);
        int row = from.row();
        int col = from.col();
        for (int i = 0; i < steps; i++) {
            if (row == to.row() && col == to.col()) break;
            row += Integer.signum(to.row() - row);
            col += Integer.signum(to.col() - col);
        }
        return new Position(row, col);
    }
}
