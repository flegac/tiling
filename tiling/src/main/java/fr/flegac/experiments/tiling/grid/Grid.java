package fr.flegac.experiments.tiling.grid;

public interface Grid {
    int getW();

    int getH();

    /**
     * convert cell position to unique cell ID
     */
    int cellId(int x, int y);

    int computeX(int cellId);

    int computeY(int cellId);

    boolean contains(int cellId);

    int getArea();
}
