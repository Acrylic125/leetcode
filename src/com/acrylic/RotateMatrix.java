package com.acrylic;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-image/
public class RotateMatrix {

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.rotate(new int[][]{
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        });
        rotateMatrix.rotate(new int[][]{
                { 1,  2,  3,  4 },
                { 5,  6,  7,  8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        });
        rotateMatrix.rotate(new int[][]{
                { 1,  2,  3,  4,  5 },
                { 6,  7,  8,  9,  10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 }
        });
    }

    public void rotateLayer(int[][] matrix,
                            int layer,
                            int lastLayer) {
        if (layer <= 1)
            return;
        int diff = lastLayer - (lastLayer - layer);
        int start = (lastLayer - layer) / 2;
        int[] row1 = new int[layer],
              row2 = new int[layer];
        for (int i = 0; i < diff; i++) {
            row1[i] = matrix[start][i + start];
            row2[i] = matrix[start + layer - 1][i + start];
        }
        int[] col1 = new int[layer - 2],
              col2 = new int[layer - 2];
        int diffM2 = diff - 2;
        for (int i = 0; i < diffM2; i++) {
            col1[i] = matrix[start + i + 1][start];
            col2[i] = matrix[start + i + 1][start + layer - 1];
        }
        boolean hasCols = col1.length > 0;
        for (int i = 0; i < diff; i++) {
            if (hasCols && (i < diffM2)) {
                matrix[start][i + start + 1] = col1[diffM2 - i - 1];
                matrix[start + layer - 1][i + start + 1] = col2[diffM2 - i - 1];
            }
            matrix[start + i][start] = row2[i];
            matrix[start + i][start + layer - 1] = row1[i];
        }
        rotateLayer(matrix, layer - 2, lastLayer);
    }

    public void rotate(int[][] matrix) {
        System.out.println("Original Matrix:");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        rotateLayer(matrix, matrix.length, matrix.length);
        System.out.println("Rotated Matrix:");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
