package com.acrylic;

import java.util.HashSet;
import java.util.Set;

public class EncodingWaysChars {

    static int MAX_CHARS = 26;
    static char[] CHARS = new char[MAX_CHARS];

    public static void main(String[] args) {
        int i = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            CHARS[i] = c;
            i++;
        }
        System.out.println(numDecodings("226"));
    }

    public static char getChar(int num) {
        return CHARS[num - 1];
    }

    public static boolean isUsable(int val) {
        return val > 0 && val <= 26;
    }

    public static int numDecodings(String s) {
        char[] encoded = s.toCharArray();
        int sizeOfEncoded = encoded.length;
        int count = 0;
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < sizeOfEncoded; i++) {
            int current = Integer.parseInt(String.valueOf(encoded[i]));
            if (isUsable(current)) {
                // If i can peek at the i+1 char
                if ((i + 1) < sizeOfEncoded) {
                    int peek = Integer.parseInt(String.valueOf(encoded[i + 1]));
                    int merge = (current * 10) + peek;
                    if (isUsable(merge)) {
                        count++;
                        characters.add(getChar(merge));
                    }
                }
                count++;
                characters.add(getChar(current));
            }
        }
        System.out.println(characters);
        return count;
    }
}
