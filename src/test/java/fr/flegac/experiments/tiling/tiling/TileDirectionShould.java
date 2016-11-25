package fr.flegac.experiments.tiling.tiling;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class TileDirectionShould {

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
    public void computeAdjacentCell() {
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
}
