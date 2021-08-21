package com.acrylic;

public class AddBinary {

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    public int getBitAt(long num, int bitIndex) {
        return ((num & ((bitIndex <= 0) ? 1 : (2L << (bitIndex - 1)))) > 0) ? 1 : 0;
    }

    static char ONE = '1';

    public int binaryStringToInt(String str) {
        int sizeA = str.length();
        int total = 0;
        for (int i = 0; i < sizeA; i++) {
            total <<= 1;
            if (str.charAt(i) == ONE)
                total++;
        }
        return total;
    }

    public String addBinary(String a, String b) {
        int intA = binaryStringToInt(a),
            intB = binaryStringToInt(b);
        int sumInt = intA + intB;
        if (sumInt == 0)
            return "0";
        StringBuilder binaryString = new StringBuilder();
        boolean seen1 = false;
        for (int i = 30; i >= 0; i--) {
            int bit = getBitAt(sumInt, i);
            if (!seen1 && bit == 1)
                seen1 = true;
            if (seen1)
                binaryString.append(bit);
        }
        return binaryString.toString();
    }

}
