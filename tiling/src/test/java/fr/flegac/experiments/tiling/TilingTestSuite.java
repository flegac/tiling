package fr.flegac.experiments.tiling;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TestGrid.class, TestTiling.class, TestOutOfBound.class, TestOverlap.class, TestFullTiling.class, TestTilingSolver.class, TestTilingFullness.class
})
public class TilingTestSuite {

}
