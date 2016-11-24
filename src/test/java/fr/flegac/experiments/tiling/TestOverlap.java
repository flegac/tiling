package fr.flegac.experiments.tiling;

import org.junit.Test;

import fr.flegac.experiments.tiling.tiling.TileDirection;
import fr.flegac.experiments.tiling.tiling.Tiling;
import fr.flegac.experiments.tiling.tiling.Tiling1;
import fr.flegac.experiments.tiling.tiling.exceptions.OverlapException;

public class TestOverlap {

    @Test(expected = OverlapException.class)
    public void checkOverlap1() {
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
    public void checkOverlap2() {
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

}
