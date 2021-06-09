package com.ds.impl.array;

public class Matrix implements ArrayAbstract {
    private final int maxRow;
    private final int maxCol;
    private final Array matrix;
    private int lastRow = 0, lastCol = 0;

    public Matrix(int row, int column) {
        maxRow = row;
        maxCol = column;
        matrix = new Array(row);
        for (int i = 0; i < row; i++) {
            Array tempArrayImpl = new Array(column);
            matrix.add(tempArrayImpl);
        }
    }

    @Override
    public Object get(int index) {
        return getRow(index);
    }

    public void add(Object element) {
        if (lastRow == maxRow) {
            throw new MatrixIndexOfOutOfBoundException(lastRow, lastCol);
        }
        if (lastCol == maxCol) {
            lastRow++;
            lastCol = 0;
        }
        getRow(lastRow).add(element);
        lastCol++;
    }

    @Override
    public void add(int index, Object object) {
        throw new UnsupportedOperationException("add(int index, Object object) is not supported on Matrix");
    }

    public void add(int row, int col, Object element) {
        if (row >= maxRow || col >= maxCol) {
            throw new MatrixIndexOfOutOfBoundException(row, col);
        }
        getRow(row).add(col, element);
    }

    public Object get(int row, int col) {
        if (row >= maxRow || col >= maxCol) {
            throw new MatrixIndexOfOutOfBoundException(row, col);
        }
        return getRow(row).get(col);
    }

    public String toString() {
        StringBuilder strMatrix = new StringBuilder();
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                strMatrix.append(get(i, j).toString()).append("\t");
            }
            strMatrix.append("\n");
        }
        return strMatrix.toString();
    }

    private Array getRow(int rowIndex) {
        return ((Array) matrix.get(rowIndex));
    }

    private static class MatrixIndexOfOutOfBoundException extends ArrayIndexOutOfBoundsException {

        public MatrixIndexOfOutOfBoundException(int row, int col) {
            super("Column index out of range : " + row + " x " + col);
        }
    }

}
