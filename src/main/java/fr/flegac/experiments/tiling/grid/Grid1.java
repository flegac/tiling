package fr.flegac.experiments.tiling.grid;

import fr.flegac.experiments.tiling.exceptions.OutOfBoundException;

public class Grid1 implements Grid {

    private final int w;

    private final int h;

    public Grid1(final int w, final int h) {
        super();
        this.w = w;
        this.h = h;
    }

    @Override
    public int getW() {
        return w;
    }

    @Override
    public int getH() {
        return h;
    }

    @Override
    public int getArea() {
        return w * h;
    }

    @Override
    public int cellId(final int x, final int y) {
        if (x < 0 || y < 0 || x >= w || y >= h) {
            throw new OutOfBoundException();
        }
        return x + y * w;
    }

    @Override
    public int computeX(final int cellId) {
        return cellId - w * computeY(cellId);
    }

    @Override
    public int computeY(final int cellId) {
        return cellId / w;
    }

    @Override
    public boolean contains(final int cellId) {
        return 0 <= cellId && cellId < w * h;
    }

    @Override
    public String toString() {
        String result = "";

        for (int y = h - 1; y >= 0; y--) {
            for (int x = 0; x < w; x++) {
                result += String.format("%5d", cellId(x, y));
            }
            result += "\n";
        }
        return result;

    }

}
