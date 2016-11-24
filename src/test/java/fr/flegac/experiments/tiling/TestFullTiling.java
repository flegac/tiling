package fr.flegac.experiments.tiling;

import org.junit.Assert;
import org.junit.Test;

import fr.flegac.experiments.tiling.tiling.TileDirection;
import fr.flegac.experiments.tiling.tiling.Tiling;
import fr.flegac.experiments.tiling.tiling.Tiling1;

public class TestFullTiling {

    @Test
    public void checkFullTiling() {
        // given
        final Tiling tiling = new Tiling1(2, 2);

        // when
        tiling.fill(tiling.cellId(0, 0), TileDirection.RIGHT);
        tiling.fill(tiling.cellId(0, 1), TileDirection.RIGHT);

        // then
        Assert.assertTrue(tiling.getEmptyCells().isEmpty());
    }

    @Test
    public void checkPartialTiling() {
        // given
        final Tiling tiling = new Tiling1(3, 3);

        // when
        tiling.fill(tiling.cellId(0, 0), TileDirection.RIGHT);
        tiling.fill(tiling.cellId(1, 1), TileDirection.UP);

        // then
        Assert.assertFalse(tiling.getEmptyCells().isEmpty());
    }

}
