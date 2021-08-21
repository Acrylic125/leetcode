package com.acrylic;

public class RotateMatrix {

    public static void main(String[] args) {

    }

    public void rotateLayer(int[][] matrix, int layer, int totalLayers) {
        if (layer <= 1)
            return;
        int lastLayer = totalLayers - layer - 1;
        int[] row1 = new int[layer],
              row2 = new int[layer];
        for (int i = 0; i < layer; i++) {
            row1[i] = matrix[layer][i];
            row2[i] = matrix[lastLayer][i];
        }
        int[] col1 = new int[layer - 2],
              col2 = new int[layer - 2];
        for (int i = 1; i < layer - 1; i++) {
            col1[i] = matrix[i - 1][0];
//            col2[i] = matrix[i - 1][layerM1];
        }
        // Rotate
        for (int i = 0; i < layer; i++) {
//            matrix[0]
        }
    }

    public void rotate(int[][] matrix) {

    }

}
