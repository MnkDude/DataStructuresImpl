package com.ds.impl.array;

public class Matrix {
    private final int maxRow;
    private final int maxCol;
    private int lastRow = 0, lastCol = 0;
    private final Array matrix;

    public Matrix(int row, int column) {
        maxRow = row;
        maxCol = column;
        matrix = new Array(row);
        for (int i = 0; i < row; i++) {
            Array tempArray = new Array(column);
            matrix.add(tempArray);
        }
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

    public void add(int row, int col, Object element) {
        if (row >= maxRow || col >= maxCol) {
            throw new MatrixIndexOfOutOfBoundException(row, col);
        }
        getRow(row).add(col,element);
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
