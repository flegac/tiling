package fr.flegac.experiments.tiling.tiling;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.flegac.experiments.tiling.grid.Grid;

public class Tile {
    private final Set<Integer> cellIds;

    public Tile(final Grid grid, final int cellId, final TileDirection direction) {
        final Set<Integer> set = Stream.of(cellId, direction.getAdjacentCellId(grid, cellId)).collect(Collectors.toSet());
        cellIds = Collections.unmodifiableSet(set);
    }

    public Set<Integer> getCellIds() {
        return cellIds;
    }

    @Override
    public String toString() {
        return cellIds.toString();
    }

}
