package fr.flegac.experiments.tiling.tiling;

import org.junit.Test;

import fr.flegac.experiments.tiling.tiling.TileDirection;
import fr.flegac.experiments.tiling.tiling.Tiling;
import fr.flegac.experiments.tiling.tiling.Tiling1;
import fr.flegac.experiments.tiling.tiling.exceptions.OutOfBoundException;

public class TestOutOfBound {

    @Test(expected = OutOfBoundException.class)
    public void checkOutOfBoundTilingDown() {
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
    public void checkOutOfBoundTilingUp() {
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
    public void checkOutOfBoundTilingRight() {
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
    public void checkOutOfBoundTilingLeft() {
        // given
        final int w = 10;
        final int h = 10;
        final Tiling tiling = new Tiling1(w, h);

        // when
        final int cellId = tiling.cellId(0, 0);
        final TileDirection orientation = TileDirection.LEFT;

        tiling.fill(cellId, orientation);
    }

    @Test(expected = OutOfBoundException.class)
    public void checkOutOfBoundTiling2() {
        // given
        final Tiling tiling = new Tiling1(10, 10);
        final int cellId = tiling.cellId(0, 0);
        final TileDirection orientation = TileDirection.DOWN;

        // when
        tiling.fill(cellId, orientation);
    }

}
