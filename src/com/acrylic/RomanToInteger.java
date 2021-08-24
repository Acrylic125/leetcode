package com.acrylic;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("X"));
        System.out.println(romanToInteger.romanToInt("XX"));
        System.out.println(romanToInteger.romanToInt("CCL"));
        System.out.println(romanToInteger.romanToInt("CMMCM"));
        System.out.println(romanToInteger.romanToInt("XIV"));
    }

    static Map<String, Integer> romanToIntegerMap = new HashMap<>();

    static {
        romanToIntegerMap.put("I", 1);
        romanToIntegerMap.put("IV", 4);
        romanToIntegerMap.put("V", 5);
        romanToIntegerMap.put("IX", 9);
        romanToIntegerMap.put("X", 10);
        romanToIntegerMap.put("XL",40);
        romanToIntegerMap.put("L", 50);
        romanToIntegerMap.put("XC", 90);
        romanToIntegerMap.put("C", 100);
        romanToIntegerMap.put("CD", 400);
        romanToIntegerMap.put("D", 500);
        romanToIntegerMap.put("CM", 900);
        romanToIntegerMap.put("M", 1000);
    }

    public int romanToInt(String s) {
        int size = s.length();
        int integer = 0;
        for (int i = 0; i < size; i++) {
            char charAt = s.charAt(i);
            if (i < (size - 1)) {
                char charAtNext = s.charAt(i + 1);
                Integer merged = romanToIntegerMap.get(String.valueOf(new char[] { charAt, charAtNext }));
                if (merged != null) {
                    integer += merged;
                    i++;
                    continue;
                }
            }
            Integer at = romanToIntegerMap.get(String.valueOf(charAt));
            if (at != null)
                integer += at;
        }
        return integer;
    }

}
