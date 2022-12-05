package com.acrylic;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] intArr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("Before: " + Arrays.toString(intArr));
        rotateArray.rotate(intArr, 1);
        System.out.println("After: " + Arrays.toString(intArr));
    }

    public void rotate(int[] nums, int k) {
        int size = nums.length;
        int sizeMK = size - k;
        for (int i = size; i >= 0; i--) {
            if (i > k) {

            }
        }
    }

}
