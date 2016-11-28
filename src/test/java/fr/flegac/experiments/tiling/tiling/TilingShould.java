package fr.flegac.experiments.tiling.tiling;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import fr.flegac.experiments.tiling.exceptions.OutOfBoundException;
import fr.flegac.experiments.tiling.exceptions.OverlapException;

public class TilingShould {

    @Test
    public void detectCompleteTiling() {
        // given
        final Tiling tiling = new Tiling1(2, 2);

        // when
        tiling.fill(tiling.cellId(0, 0), TileDirection.RIGHT);
        tiling.fill(tiling.cellId(0, 1), TileDirection.RIGHT);

        // then
        Assert.assertTrue(tiling.getEmptyCells().isEmpty());
    }

    @Test
    public void detectPartialTiling() {
        // given
        final Tiling tiling = new Tiling1(3, 3);

        // when
        tiling.fill(tiling.cellId(0, 0), TileDirection.RIGHT);
        tiling.fill(tiling.cellId(1, 1), TileDirection.UP);

        // then
        Assert.assertFalse(tiling.getEmptyCells().isEmpty());
    }

    @Test
    public void beEmptyByDefault() {
        // given
        final Tiling tiling = new Tiling1(3, 3);

        // when
        tiling.fill(0, TileDirection.RIGHT);

        // then
        final Set<Integer> expected = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8));

        Assert.assertEquals(expected, tiling.getEmptyCells());
    }

    @Test
    public void fillSomeCellsAfterTileCreation() {
        // given
        final Tiling tiling = new Tiling1(3, 3);

        // when
        tiling.fill(0, TileDirection.RIGHT);

        // then
        final Set<Integer> expected = new HashSet<>(Arrays.asList(0, 1));
        Assert.assertEquals(expected, tiling.getTiledCells());
    }

    @Test
    public void fillTheCellCoveredByTheTile() {
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
    public void computeTileCoverageRatio() {
        // given
        final int w = 10;
        final int h = 12;
        final Tiling tiling = new Tiling1(w, h);
        final TileDirection direction = TileDirection.RIGHT;

        // when
        tiling.fill(0, direction);
        tiling.fill(2, direction);
        tiling.fill(4, direction);

        // then
        Assert.assertEquals(6f / (w * h), tiling.computeTilingRatio(), .0f);
    }

    @Test
    public void detectEmptyCellAfterTileRemoval() {
        // given
        final Tiling tiling = new Tiling1(10, 10);
        final int cellId = tiling.cellId(5, 5);
        final TileDirection direction = TileDirection.RIGHT;
        tiling.fill(cellId, direction);

        // when
        tiling.empty(cellId);

        // then
        Assert.assertNull(tiling.getTile(cellId));
        Assert.assertNull(tiling.getTile(direction.getAdjacentCellId(tiling, cellId)));

    }

    @Test(expected = OutOfBoundException.class)
    public void detectOutOfBoundTilingDown() {
        // given
        final int w = 10;
        final int h = 10;
        final Tiling tiling = new Tiling1(w, h);

        // when
        final int cellId = tiling.cellId(0, 0);
        final TileDirection orientation = TileDirection.DOWN;

        tiling.fill(cellId, orientation);
    }

    @Test(expected = OutOfBoundException.class)
    public void detectOutOfBoundTilingUp() {
        // given
        final int w = 10;
        final int h = 10;
        final Tiling tiling = new Tiling1(w, h);

        // when
        final int cellId = tiling.cellId(0, h - 1);
        final TileDirection orientation = TileDirection.UP;

        tiling.fill(cellId, orientation);
    }

    @Test(expected = OutOfBoundException.class)
    public void detectOutOfBoundTilingRight() {
        // given
        final int w = 10;
        final int h = 10;
        final Tiling tiling = new Tiling1(w, h);

        // when
        final int cellId = tiling.cellId(w - 1, 0);
        final TileDirection orientation = TileDirection.RIGHT;

        tiling.fill(cellId, orientation);
    }

    @Test(expected = OutOfBoundException.class)
    public void detectOutOfBoundTilingLeft() {
        // given
        final int w = 10;
        final int h = 10;
        final Tiling tiling = new Tiling1(w, h);

        // when
        final int cellId = tiling.cellId(0, 0);
        final TileDirection orientation = TileDirection.LEFT;

        tiling.fill(cellId, orientation);
    }

    @Test(expected = OverlapException.class)
    public void detectOverlapingTiles1() {
        // given
        final Tiling tiling = new Tiling1(10, 10);
        final int cellId = tiling.cellId(5, 5);
        final TileDirection orientation1 = TileDirection.RIGHT;
        final TileDirection orientation2 = TileDirection.LEFT;

        // when
        tiling.fill(cellId, orientation1);
        tiling.fill(orientation1.getAdjacentCellId(tiling, cellId), orientation2);
    }

    @Test(expected = OverlapException.class)
    public void detectOverlapingTiles2() {
        // given
        final Tiling tiling = new Tiling1(10, 10);
        final int cellId = tiling.cellId(5, 5);
        final TileDirection orientation1 = TileDirection.RIGHT;

        final int cellId2 = tiling.cellId(5, 4);
        final TileDirection orientation2 = TileDirection.UP;

        // when
        tiling.fill(cellId, orientation1);
        tiling.fill(cellId2, orientation2);
    }

    @Test
    public void shouldRememberWhichTileCoversTwoAdjacentCells() {
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
    public void tileTheSameCellsAsThoseDefinedByTheTileDirection() {
        // given
        final Tiling tiling = new Tiling1(10, 10);
        final int cellId = tiling.cellId(5, 5);
        final TileDirection direction = TileDirection.RIGHT;
        final int cellId2 = direction.getAdjacentCellId(tiling, cellId);

        // when
        tiling.fill(cellId, direction);
        final Tile tile = tiling.getTile(cellId);
        final Set<Integer> tiledCells = tile.getCellIds();

        // then
        Assert.assertTrue(tiledCells.contains(cellId));
        Assert.assertTrue(tiledCells.contains(cellId2));
    }
}
