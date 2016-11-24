package fr.flegac.experiments.tiling.tiling;

import java.util.Random;

import fr.flegac.experiments.tiling.grid.Grid;

public enum TileDirection {
    UP(0, 1), DOWN(0, -1), RIGHT(1, 0), LEFT(-1, 0);

    private int dx;

    private int dy;

    private TileDirection(final int dx, final int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getAdjacentCellId(final Grid grid, final int cellId) {
        return grid.cellId(grid.computeX(cellId) + dx, grid.computeY(cellId) + dy);
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public static TileDirection random(final Random rand) {
        TileDirection[] values = values();
        return values[rand.nextInt(values.length)];
    }
}
