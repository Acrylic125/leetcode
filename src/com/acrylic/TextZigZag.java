package com.acrylic;

public class TextZigZag {

    public static void main(String[] args) {

    }

    public String convert(String s, int numRows) {
        final int size = s.length();
        StringBuilder builder = new StringBuilder(size);
        int rowSelector = 0, rowIncrementer = 1;
        for (int i = 0; i < size; i++) {
            char cAt = s.charAt(i);
            int mod = i % numRows;
            if (rowIncrementer == 1) {
                if (mod == 0) {
                    rowIncrementer = -1;
                }
            } else {
                if (mod == 0) {
                    rowIncrementer = -1;
                }
            }

            rowSelector += rowIncrementer;

        }
        return builder.toString();
    }

}
