package com.acrylic;

public class ExcelColumnToTitle {

    public static void main(String[] args) {
        ExcelColumnToTitle excelColumnToTitle = new ExcelColumnToTitle();
        System.out.println(excelColumnToTitle.convertToTitle(701));
    }

    public String convertToTitle(int columnNumber) {
        int reduce = columnNumber;
        String title = "";
        do {
            int mod = reduce % 26;
            System.out.println((char) (mod + 64) + " " + reduce);
            title = ((char) (mod + 64)) + title;
            reduce -= mod;
            reduce /= 26;
        } while (reduce > 0);
        return title;
    }

}
