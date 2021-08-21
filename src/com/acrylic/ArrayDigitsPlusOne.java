package com.acrylic;

import java.util.Arrays;

public class ArrayDigitsPlusOne {

    public static void main(String[] args) {
        ArrayDigitsPlusOne arrayDigitsPlusOne = new ArrayDigitsPlusOne();
        System.out.println(Arrays.toString(arrayDigitsPlusOne.plusOne(new int[]{9, 9, 9, 9, 9})));
    }

    public boolean areDigitsAll9s(int[] digits) {
        for (int digit : digits) {
            if (digit != 9)
                return false;
        }
        return true;
    }

    public int[] plusOne(int[] digits) {
        int size = digits.length;
        int MSD = digits[0];
        if (MSD == 9 && areDigitsAll9s(digits)) {
            int[] newDigits = new int[size + 1];
            newDigits[0] = 1;
            return newDigits;
        } else {
            int[] newArr = new int[size];
            boolean done = false;
            for (int i = size - 1; i >= 0; i--) {
                int digit = digits[i];
                if (!done) {
                    if (digit == 9) {
                        newArr[i] = 0;
                    } else {
                        done = true;
                        newArr[i] = digit + 1;
                    }
                } else {
                    newArr[i] = digit;
                }
            }
            return newArr;
        }
    }

}
