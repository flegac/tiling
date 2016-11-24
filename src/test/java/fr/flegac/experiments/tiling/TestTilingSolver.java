package fr.flegac.experiments.tiling;

import org.junit.Assert;
import org.junit.Test;

import fr.flegac.experiments.tiling.solver.DumbTilingSolver;
import fr.flegac.experiments.tiling.solver.SmartTilingSolver;
import fr.flegac.experiments.tiling.solver.TilingSolver;
import fr.flegac.experiments.tiling.tiling.Tiling;

public class TestTilingSolver {

    @Test
    public void checkSuccess() {
        // given
        final int N = 100000;
        final TilingSolver algorithm = new SmartTilingSolver(3, 4);

        // when
        final Tiling tiling = algorithm.solve(N);

        // then
        Assert.assertTrue(tiling.getEmptyCells().isEmpty());
    }

    @Test
    public void checkFailure() {
        // given
        final int N = 100000;
        final TilingSolver algorithm = new DumbTilingSolver(1, 1);

        // when
        final Tiling tiling = algorithm.solve(N);

        // then
        Assert.assertFalse(tiling.getEmptyCells().isEmpty());
    }

    @Test
    public void checkBigTiling() {
        // given
        final int N = 1000000;
        final int W = 18;
        final int H = 16;
        final TilingSolver algorithm = new SmartTilingSolver(W, H);

        // when
        final Tiling tiling = algorithm.solve(N);

        // then
        Assert.assertTrue(tiling.getEmptyCells().isEmpty());
    }
}
