package com.acrylic;

public class Parentheses {

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        System.out.println(parentheses.longestValidParentheses("()(()"));
        System.out.println(parentheses.longestValidParentheses(")()())"));
        System.out.println(parentheses.longestValidParentheses("(()"));
    }

    static char OPEN = '(', CLOSE = ')';

    // int[] where 0 is the accumulated, 1 is the closing index.
    public int[] scanParentheses(final String fullString,
                                 int index,
                                 final int lastIndex,
                                 int depth) {
        System.out.println("Depth=" + depth + " Opened");
        int accum = 0, softAccum = 0;
        boolean opened = false;
        while (index <= lastIndex) {
            char cAt = fullString.charAt(index);
            System.out.println(depth + " : " + index + ". " + cAt + " beforeAccum=" + accum);
            if (cAt == OPEN) {
                if (opened) {
                    int[] extracted = scanParentheses(fullString, index + 1, lastIndex, depth + 1);
                    softAccum += extracted[0];
                    index = extracted[1];
                } else {
                    opened = true;
                }
            } else if (cAt == CLOSE) {
                System.out.println("Depth=" + depth + " Closed " + opened);
                if (depth != 0) {
                    return new int[] { softAccum + 2, index };
                } else {
                    if (opened) {
                        accum += softAccum + 2;
                        opened = false;
                    }
                }
            }
            index++;
        }
        return new int[] { accum, index };
    }

    public int longestValidParentheses(String s) {
        final int length = s.length();
        if (length == 0)
            return 0;
        return scanParentheses(s, 0, length - 1, 0)[0];
    }

}
