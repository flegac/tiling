package fr.flegac.experiments.tiling;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import fr.flegac.experiments.tiling.tiling.TileDirection;
import fr.flegac.experiments.tiling.tiling.Tiling;
import fr.flegac.experiments.tiling.tiling.Tiling1;

public class TestTilingFullness {

    @Test
    public void checkEmptyCell() {
        // given
        final Tiling tiling = new Tiling1(3, 3);

        // when
        tiling.fill(0, TileDirection.RIGHT);

        // then
        final Set<Integer> expected = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8));

        Assert.assertEquals(expected, tiling.getEmptyCells());
    }

    @Test
    public void checkTiledCells() {
        // given
        final Tiling tiling = new Tiling1(3, 3);

        // when
        tiling.fill(0, TileDirection.RIGHT);

        // then
        final Set<Integer> expected = new HashSet<>(Arrays.asList(0, 1));
        Assert.assertEquals(expected, tiling.getTiledCells());
    }

    @Test
    public void checkRandomTileDirection() {
        // given
        final Random rand = new Random();
        final int N = 100000;
        final int[] generated = new int[TileDirection.values().length];

        // when
        for (int i = 0; i < N * generated.length; i++) {
            generated[TileDirection.random(rand).ordinal()]++;
        }

        // then
        // then
        for (final int value : generated) {
            Assert.assertTrue(value > N * .8);
            Assert.assertTrue(value < N * 1.2);
        }
    }

    @Test
    public void checkEmptyTiling() {
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

    @Test
    public void checkTilingRatio() {
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

}
