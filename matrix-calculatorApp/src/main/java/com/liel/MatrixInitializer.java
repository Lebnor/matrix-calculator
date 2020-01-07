package com.liel;

public interface MatrixInitializer {
    void initializeMatrix(int[][] matrix);

    static MatrixInitializer getRandomMatrixInitializer() {
        return null;
    }
}
