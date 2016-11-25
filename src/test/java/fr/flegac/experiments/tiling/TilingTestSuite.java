package fr.flegac.experiments.tiling;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.flegac.experiments.tiling.grid.TestGrid;
import fr.flegac.experiments.tiling.solver.TestTilingSolver;
import fr.flegac.experiments.tiling.tiling.TestFullTiling;
import fr.flegac.experiments.tiling.tiling.TestOutOfBound;
import fr.flegac.experiments.tiling.tiling.TestOverlap;
import fr.flegac.experiments.tiling.tiling.TestTiling;
import fr.flegac.experiments.tiling.tiling.TestTilingFullness;

@RunWith(Suite.class)
@SuiteClasses({
    TestGrid.class, TestTiling.class, TestOutOfBound.class, TestOverlap.class, TestFullTiling.class, TestTilingSolver.class, TestTilingFullness.class
})
public class TilingTestSuite {

}
