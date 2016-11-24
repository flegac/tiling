package fr.flegac.experiments.tiling;

import org.junit.Assert;
import org.junit.Test;

import fr.flegac.experiments.tiling.grid.Grid;
import fr.flegac.experiments.tiling.grid.Grid1;

public class TestGrid {

    @Test
    public void checkGridSize() {
        // given
        final int W = 12;
        final int H = 32;
        final Grid grid = new Grid1(W, H);

        // then
        Assert.assertEquals(H, grid.getH());
        Assert.assertEquals(W, grid.getW());
    }

    @Test
    public void checkGridCoordinateSystem() {
        // given
        final Grid grid = new Grid1(20, 20);

        for (int x = 0; x < grid.getW(); x++) {
            for (int y = 0; y < grid.getH(); y++) {
                // when
                final int cellId = grid.cellId(x, y);

                // then
                Assert.assertEquals(x, grid.computeX(cellId));
                Assert.assertEquals(y, grid.computeY(cellId));
            }
        }
    }

    @Test
    public void checkGridContains() {
        // given
        final int w = 12;
        final int h = 14;

        // when
        final Grid grid = new Grid1(w, h);

        // then
        Assert.assertFalse(grid.contains(-1));
        Assert.assertTrue(grid.contains(0));
        Assert.assertTrue(grid.contains(w * h - 1));
        Assert.assertFalse(grid.contains(w * h));
        Assert.assertFalse(grid.contains(w * h + 1));
    }

    @Test
    public void checkGridArea() {
        // given
        final int h = 12;
        final int w = 15;

        // when
        final Grid grid = new Grid1(w, h);

        // then
        Assert.assertEquals(h * w, grid.getArea());

    }

}
