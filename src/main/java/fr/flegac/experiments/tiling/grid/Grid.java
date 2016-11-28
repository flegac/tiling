package fr.flegac.experiments.tiling.grid;

public interface Grid {
    int getWidth();

    int getHeight();

    int cellId(int x, int y);

    int computeX(int cellId);

    int computeY(int cellId);

    boolean contains(int cellId);

    int computeArea();
}
