package fr.flegac.experiments.tiling;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.flegac.experiments.tiling.grid.GridShould;
import fr.flegac.experiments.tiling.solver.DumbSolverShould;
import fr.flegac.experiments.tiling.solver.SmartSolverShould;
import fr.flegac.experiments.tiling.tiling.TileDirectionShould;
import fr.flegac.experiments.tiling.tiling.TilingShould;

@RunWith(Suite.class)
@SuiteClasses({
    GridShould.class, TileDirectionShould.class, TilingShould.class, DumbSolverShould.class, SmartSolverShould.class
})
public class TilingTestSuite {

}
