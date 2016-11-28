package fr.flegac.experiments.tiling.tiling;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.flegac.experiments.tiling.exceptions.OverlapException;
import fr.flegac.experiments.tiling.grid.Grid1;

public class Tiling1 extends Grid1 implements Tiling {
    private final Map<Integer, Tile> tiles = new HashMap<>();

    private final Set<Integer> emptyCells;

    public Tiling1(final int w, final int h) {
        super(w, h);
        emptyCells = new HashSet<>();
        for (int i = 0; i < computeArea(); i++) {
            emptyCells.add(i);
        }
    }

    @Override
    public void fill(final int cellId, final TileDirection direction) {
        final int adjacentCell = direction.getAdjacentCellId(this, cellId);
        if (tiles.containsKey(cellId)) {
            throw new OverlapException();
        }
        if (tiles.containsKey(adjacentCell)) {
            throw new OverlapException();
        }

        final Tile tile = new Tile(this, cellId, direction);
        tile.getCellIds().stream().forEach(item -> {
            tiles.put(item, tile);
            emptyCells.remove(item);
        });
    }

    @Override
    public Tile getTile(final int cellId) {
        return tiles.get(cellId);
    }

    @Override
    public void empty(final int cellId) {
        if (getTile(cellId) == null) {
            return;
        }
        final Tile tile = getTile(cellId);
        tile.getCellIds().stream().forEach(item -> {
            tiles.remove(item);
            emptyCells.add(item);
        });
    }

    @Override
    public String toString() {
        return super.toString() + "Tiling: " + getTiles().toString();
    }

    @Override
    public Set<Tile> getTiles() {
        return new HashSet<>(tiles.values());
    }

    @Override
    public float computeTilingRatio() {
        return 1f * getTiledCells().size() / computeArea();
    }

    @Override
    public Set<Integer> getEmptyCells() {
        return emptyCells;
    }

    @Override
    public Set<Integer> getTiledCells() {
        return tiles.keySet();
    }

}
