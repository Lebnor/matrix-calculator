package com.liel;

import java.util.Random;

public class MatrixMultiplicationUtility {
    static Random random = new Random();

    public static void main(String[] args) {

        // just some tests
        MatrixInitializer initializer = selectRandomInitializer();
        int[][] a = new int[3][3];
        initializer.initializeMatrix(a);

        int[][] b = new int[3][3];
        initializer = selectRandomInitializer();
        initializer.initializeMatrix(b);

        printMatrix(a);
        System.out.println();
        printMatrix(b);

        System.out.println();
        int[][] c = matrixMultiplication(a, b);
        printMatrix(c);
    }

    public static MatrixInitializer selectRandomInitializer(){
        int chance = random.nextInt(10);
        System.out.println("Chance: " + chance);
        if (chance < 5){
            return new SameNumberMatrixInitializer(random.nextInt(99));
        }else {
            return new RandomNumberMatrixInitializer();
        }
    }

    public static int[][] matrixMultiplication(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
