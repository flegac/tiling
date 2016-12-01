package fr.flegac.experiments.tiling.solver;

import fr.flegac.experiments.tiling.exceptions.OutOfBoundException;
import fr.flegac.experiments.tiling.exceptions.OverlapException;
import fr.flegac.experiments.tiling.tiling.TileDirection;
import fr.flegac.experiments.tiling.tiling.Tiling;

public class SmartTilingSolver extends AbstractTilingSolver {
    private static final int MAX_FAILS_IN_A_ROW = 10;

    private int failed;

    public SmartTilingSolver(final int w, final int h) {
        super(w, h);
    }

    @Override
    protected void update(final Tiling tiling) {

        if (failed == MAX_FAILS_IN_A_ROW && !tiling.getTiledCells().isEmpty()) {
            tiling.empty(getRandomCell(tiling.getTiledCells()));
            failed = 0;
        }

        final int cellId = getRandomEmptyCell();
        final TileDirection direction = getSmartRandomDirection(cellId);

        try {
            tiling.fill(cellId, direction);
        }
        catch (final OutOfBoundException | OverlapException e) {
            failed++;
        }
    }

}
