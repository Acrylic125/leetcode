package com.acrylic;

public class StringNeedleInHaystack {

    public static void main(String[] args) {
        StringNeedleInHaystack needleInHaystack = new StringNeedleInHaystack();
        System.out.println(needleInHaystack.strStr("mississippi", "pi"));
    }

    public int strStr(String haystack, String needle) {
        int hayStackSize = haystack.length();
        int needleSize = needle.length();
        if (needleSize == 0)
            return 0;
        if (needleSize > hayStackSize)
            return -1;
        if (needleSize == hayStackSize)
            return (haystack.equals(needle)) ? 0 : -1;
        for (int i = 0; i < hayStackSize; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean isValid = true;
                for (int j = 1; j < needleSize; j++) {
                    int hayStackIndex = j + i;
                    if (hayStackIndex >= hayStackSize || haystack.charAt(hayStackIndex) != needle.charAt(j)) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid)
                    return i;
            }
        }
        return -1;
    }

}
