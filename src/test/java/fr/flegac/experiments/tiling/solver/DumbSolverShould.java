package fr.flegac.experiments.tiling.solver;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import fr.flegac.experiments.tiling.tiling.Tiling;

public class DumbSolverShould {

    @Test
    public void failForOddNumberOfCells() {
        // given
        final int N = 100000;
        final TilingSolver algorithm = new DumbTilingSolver(1, 1);

        // when
        final Tiling tiling = algorithm.solve(N);

        // then
        Assertions.assertThat(tiling.getEmptyCells()).isNotEmpty();
    }
}
