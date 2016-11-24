package fr.flegac.experiments.tiling.solver;

import fr.flegac.experiments.tiling.tiling.Tiling;

@FunctionalInterface
public interface TilingSolver {
    Tiling solve(int maxIterrations);
}
