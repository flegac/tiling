package fr.flegac.experiments.tiling.solver;

import fr.flegac.experiments.tiling.tiling.TileDirection;
import fr.flegac.experiments.tiling.tiling.Tiling;
import fr.flegac.experiments.tiling.tiling.exceptions.OutOfBoundException;
import fr.flegac.experiments.tiling.tiling.exceptions.OverlapException;

public class DumbTilingSolver extends AbstractTilingSolver {

    public DumbTilingSolver(final int w, final int h) {
        super(w, h);
    }

    @Override
    protected void update(final Tiling tiling) {
        final int cellId = getRandomCell(tiling.getEmptyCells());
        final TileDirection direction = getRandomDirection();

        try {
            tiling.fill(cellId, direction);
        }
        catch (final OutOfBoundException | OverlapException e) {
            tiling.empty(cellId);
        }
    }

}
