package fr.flegac.experiments.tiling.tiling;

import java.util.Set;

import fr.flegac.experiments.tiling.grid.Grid;

public interface Tiling extends Grid {

    void fill(int cellId, TileDirection direction);

    void empty(int cellId);

    Tile getTile(int cellId);

    Set<Tile> getTiles();

    float computeTilingRatio();

    Set<Integer> getEmptyCells();

    Set<Integer> getTiledCells();
}
