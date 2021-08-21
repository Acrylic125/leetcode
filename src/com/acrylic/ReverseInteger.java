package com.acrylic;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(311111131));
    }

    static int MAX_INT_D10 = Integer.MAX_VALUE / 10,
               MIN_INT_D10 = Integer.MIN_VALUE / 10;

    public int reverse(int x) {
        boolean isNeg = x < 0;
        int posX = (isNeg) ? -x : x;
        int digits = (int) (Math.floor(Math.log10(posX)) + 1);
        int reversed = 0;
        for (int i = 0; i < digits; i++) {
            reversed *= 10;
            int lastDigit = posX % 10;
            int sum = reversed + lastDigit;
            if (sum > MAX_INT_D10)
                return 0;
            reversed = sum;
            System.out.println(i + ". " + reversed + " " + sum + " " + MAX_INT_D10);
            posX /= 10;
        }
        return (isNeg ? -1 : 1) * reversed;
    }
}
