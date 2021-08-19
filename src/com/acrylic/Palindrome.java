package com.acrylic;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }

    public static int digitAt(int digitIndex, int num, int size) {
        int tailReduce = (int) Math.pow(10, size - (digitIndex + 1));
        int reduced = num / tailReduce;
        return reduced % 10;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int size = (int) Math.floor(Math.log10(x)) + 1;
        int checkUpTo = (size % 2 == 0) ? (size / 2) : ((size - 1) / 2);
        for (int i = 0; i < checkUpTo; i++) {
            if (digitAt(i, x, size) != digitAt((size - i - 1), x, size))
                return false;
        }
        return true;
    }
}
