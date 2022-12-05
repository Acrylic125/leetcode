package com.acrylic;

public class BitwiseDivision {

    public static void main(String[] args) {
//        System.out.println((5 << 1));
        BitwiseDivision bitwiseDivision = new BitwiseDivision();
        System.out.println(bitwiseDivision.divide(-2_147_483_648, -2_147_483_648));
    }

    // To extract the bit of a given number based on a given index,
    // we use the fact that 2^n -> 1000...0000 (n times).
    // We use that number to AND the num, to extract the digit.
    // 0th index based. LSB is the 0th index.
    public int getBitAt(long num, int bitIndex) {
        return ((num & ((bitIndex <= 0) ? 1 : (2L << (bitIndex - 1)))) > 0) ? 1 : 0;
    }

    public int divide(int dividend, int divisor) {
        boolean overflowDivisor = divisor == Integer.MIN_VALUE;
        boolean overflowBelow = (dividend <= Integer.MIN_VALUE);
        if (overflowDivisor && overflowBelow)
            return 1;
        if (overflowDivisor)
            return 0;
        // Get the MSB (Sign bit).
        boolean isDividendNeg = (dividend >> 31) == -1;
        boolean isDivisorNeg = (divisor >> 31) == -1;
        // True if only either the divisor or the dividend is neg.
        boolean isNeg = isDividendNeg ^ isDivisorNeg;

        long newDividend = dividend;
        long newDivisor = divisor;
        // Convert the dividend and divisor to positive by flipping all
        // bits from neg to pos 2's to complement
        if (isDividendNeg)
            newDividend = ~dividend + 1;
        if (isDivisorNeg)
            newDivisor = ~divisor + 1;
        long quotient = 0, reduced = 0;
        final int start = (overflowBelow) ? 31 : 30;
        for (int i = start; i >= 0; i--) {
            int bit = getBitAt(newDividend, i);
            reduced = reduced << 1;
            reduced += bit;
            if (reduced >= newDivisor) {
                quotient += ((i == 0) ? 1 : (2L << (i - 1)));
                reduced -= newDivisor;
            }
        }
        if ((!isNeg) && (-quotient <= Integer.MIN_VALUE))
            return Integer.MAX_VALUE;
        return (int) ((isNeg) ? -quotient : quotient);
    }

}
