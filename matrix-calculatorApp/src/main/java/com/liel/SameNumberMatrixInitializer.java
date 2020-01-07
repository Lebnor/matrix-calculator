package com.liel;

public class SameNumberMatrixInitializer implements MatrixInitializer {

    private int numberToInitialize;

    public SameNumberMatrixInitializer(int numberToInitialize) {
        this.numberToInitialize = numberToInitialize;
    }

    @Override
    public void initializeMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = numberToInitialize;
                }
            }

    }
}
