package com.acrylic;

//https://leetcode.com/problems/multiply-strings/
public class MultiplyStrings {

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("2", "3"));
        System.out.println(multiplyStrings.multiply("4", "5"));
        System.out.println(multiplyStrings.multiply("11", "21"));
        System.out.println(multiplyStrings.multiply("66", "662"));
    }

    public int toDigitFromChar(char aChar) {
        switch (aChar) {
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            default: return 0;
        }
    }

    public long stringToInt(String s) {
        int length1 = s.length();
        int m = 1;
        int toInt = 0;
        for (int i = length1 - 1; i >= 0; i--) {
            int d = toDigitFromChar(s.charAt(i));
            toInt += (d * m);
            m *= 10;
        }
        return toInt;
    }

    public String multiply(String num1, String num2) {
        long int1 = stringToInt(num1), int2 = stringToInt(num2);
        long product = int1 * int2;
        return product + "";
    }

}
