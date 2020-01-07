package com.liel;

public class RandomNumberMatrixInitializer implements MatrixInitializer {
    @Override
    public void initializeMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
    }
}
