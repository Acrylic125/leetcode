package com.acrylic;

public class AddDigits {

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        System.out.println(addDigits.addDigits(11));
        System.out.println(addDigits.addDigits(111));
        System.out.println(addDigits.addDigits(38));
        System.out.println(addDigits.addDigits(0));
        System.out.println(addDigits.addDigits(51112));
    }

    public int addDigitsRecursively(int num) {
        int digits = (int) (Math.floor(Math.log10(num)) + 1);
        int reduced = num, sum = 0;
        for (int i = 0; i < digits; i++) {
            sum += reduced % 10;
            reduced /= 10;
        }
        return (sum > 9) ? addDigitsRecursively(sum) : sum;
    }

    public int addDigits(int num) {
        return addDigitsRecursively(num);
    }

}
