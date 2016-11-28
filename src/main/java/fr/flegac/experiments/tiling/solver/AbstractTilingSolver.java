package fr.flegac.experiments.tiling.solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import fr.flegac.experiments.tiling.exceptions.OutOfBoundException;
import fr.flegac.experiments.tiling.tiling.TileDirection;
import fr.flegac.experiments.tiling.tiling.Tiling;
import fr.flegac.experiments.tiling.tiling.Tiling1;

public abstract class AbstractTilingSolver implements TilingSolver {
    private final Tiling tiling;

    private final Random random = new Random();

    protected int getRandomCell(final Set<Integer> cells) {
        final List<Integer> cellList = new ArrayList<>(cells);
        return cellList.get(random.nextInt(cellList.size()));
    }

    protected TileDirection getSmartRandomDirection(final int cellId) {
        final List<TileDirection> list = new ArrayList<>(EnumSet.allOf(TileDirection.class));
        Collections.shuffle(list);

        for (final TileDirection direction : list) {
            try {
                if (tiling.getEmptyCells().contains(direction.getAdjacentCellId(tiling, cellId))) {
                    return direction;
                }
            }
            catch (final OutOfBoundException e) {
                continue;
            }
        }
        return getRandomDirection();
    }

    protected TileDirection getRandomDirection() {
        final TileDirection[] values = TileDirection.values();
        return values[random.nextInt(values.length)];
    }

    protected int getRandomEmptyCell() {
        return getRandomCell(tiling.getEmptyCells());
    }

    public AbstractTilingSolver(final int w, final int h) {
        super();
        tiling = new Tiling1(w, h);
    }

    protected abstract void update(Tiling tiling);

    @Override
    public Tiling solve(final int maxIterations) {
        int iterrations = 0;
        while (!tiling.getEmptyCells().isEmpty() && iterrations < maxIterations) {
            update(tiling);
            iterrations++;
        }
        final String result = tiling.getEmptyCells().isEmpty() ? String.format("OK in %d iterrations", iterrations)
            : String.format("KO : %d empty cells [%3.0f%% complete]", tiling.getEmptyCells().size(), 100 * tiling.computeTilingRatio());
        System.out.println(result);
        System.out.println(tiling);
        return tiling;
    }

}
