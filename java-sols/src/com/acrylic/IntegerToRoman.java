package com.acrylic;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman itr = new IntegerToRoman();
        System.out.println(itr.intToRoman(3));
        System.out.println(itr.intToRoman(4));
        System.out.println(itr.intToRoman(9));
        System.out.println(itr.intToRoman(58));
        System.out.println(itr.intToRoman(1994));
        System.out.println(itr.intToRoman(3999));
        System.out.println(itr.intToRoman(1));
        System.out.println(itr.intToRoman(494));
    }

    public String resolveDigitPlacement(int placement, int digit) {
        switch (placement) {
            case 1: return resolveDigitPlacement1(digit);
            case 2: return resolveDigitPlacement2(digit);
            case 3: return resolveDigitPlacement3(digit);
            case 4: return resolveDigitPlacement4(digit);
            default:
                return "";
        }
    }

    static String I = "I";
    static String IV = "IV";
    static String V = "V";
    static String IX = "IX";
    static String X = "X";
    static String XL = "XL";
    static String L = "L";
    static String XC = "XC";
    static String C = "C";
    static String CD = "CD";
    static String D = "D";
    static String CM = "CM";
    static String M = "M";

    public String resolveDigitPlacement1(int digit) {
        return resolveDigitPlacement(digit, IV, IX, V, I);
    }

    public String resolveDigitPlacement2(int digit) {
        return resolveDigitPlacement(digit, XL, XC, L, X);
    }

    public String resolveDigitPlacement3(int digit) {
        return resolveDigitPlacement(digit, CD, CM, D, C);
    }

    public String resolveDigitPlacement4(int digit) {
        return resolveDigitPlacement(digit, M, M, M, M);
    }

    public String resolveDigitPlacement(int digit,
                                        String result1,
                                        String result2,
                                        String half,
                                        String base) {
        if (digit == 9) return result2;
        if (digit == 4) return result1;
        boolean isGreaterThan5 = digit >= 5;
        StringBuilder resolved = new StringBuilder((isGreaterThan5) ? half : "");
        int amtOfIs = digit;
        if (isGreaterThan5)
            amtOfIs -= 5;
        resolved.append(base.repeat(amtOfIs));
        return resolved.toString();
    }


    public String intToRoman(int num) {
        int reducedNum = num;
        String roman = "";
        int i = 1;
        while (reducedNum > 0) {
            // Extract the last digit, then shift
            int lastDigit = reducedNum % 10;
            reducedNum -= lastDigit;
            reducedNum /= 10;
            // Used the last digit and fix it to it's actual placement.
            roman = resolveDigitPlacement(i, lastDigit) + roman;
            i++;
        }
        return roman;
    }

}
