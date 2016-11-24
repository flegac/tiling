package fr.flegac.experiments.tiling;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import fr.flegac.experiments.tiling.tiling.Tile;
import fr.flegac.experiments.tiling.tiling.TileDirection;
import fr.flegac.experiments.tiling.tiling.Tiling;
import fr.flegac.experiments.tiling.tiling.Tiling1;

public class TestTiling {

    @Test
    public void checkTileDirections() {
        // given
        final Tiling tiling = new Tiling1(10, 10);
        final int cellId = tiling.cellId(5, 5);

        for (final TileDirection direction : TileDirection.values()) {
            // when
            final int cellId2 = direction.getAdjacentCellId(tiling, cellId);

            // then
            Assert.assertEquals(tiling.cellId(5 + direction.getDx(), 5 + direction.getDy()), cellId2);
            Assert.assertEquals(direction, TileDirection.valueOf(direction.name()));
        }
    }

    @Test
    public void checkValidTiling() {
        // given
        final Tiling tiling = new Tiling1(10, 10);
        final int cellId = tiling.cellId(3, 8);
        final TileDirection orientation = TileDirection.RIGHT;

        // when
        tiling.fill(cellId, orientation);

        // then
        Assert.assertNotNull(tiling.getTile(cellId));
        Assert.assertNotNull(tiling.getTile(orientation.getAdjacentCellId(tiling, cellId)));
    }

    @Test
    public void checkTiling1() {
        // given
        final Tiling tiling = new Tiling1(10, 10);
        final int cellId = tiling.cellId(5, 5);
        final TileDirection orientation = TileDirection.RIGHT;
        final int cellId2 = orientation.getAdjacentCellId(tiling, cellId);

        // when
        tiling.fill(cellId, orientation);

        // then
        Assert.assertNotNull(tiling.getTile(cellId));
        Assert.assertEquals(tiling.getTile(cellId), tiling.getTile(cellId2));
    }

    @Test
    public void checkTiling2() {
        // given
        final Tiling tiling = new Tiling1(10, 10);
        final int cellId = tiling.cellId(5, 5);
        final TileDirection direction = TileDirection.RIGHT;
        final int cellId2 = direction.getAdjacentCellId(tiling, cellId);

        // when
        tiling.fill(cellId, direction);
        final Tile tile = tiling.getTile(cellId);
        final Set<Integer> cells = tile.getCellIds();

        // then
        Assert.assertTrue(cells.contains(cellId));
        Assert.assertTrue(cells.contains(cellId2));
    }

}
