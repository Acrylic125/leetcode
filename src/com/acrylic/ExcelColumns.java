package com.acrylic;

public class ExcelColumns {

    public static void main(String[] args) {
        ExcelColumns excelColumns = new ExcelColumns();
        System.out.println(excelColumns.titleToNumber("AAAA"));
    }

    public int titleToNumber(String columnTitle) {
        int size = columnTitle.length();
        int num = 0;
        for (int i = size - 1; i >= 0; i--) {
            char cAt = columnTitle.charAt(size - i - 1);
            num += (cAt - 64) * Math.pow(26, (i));
        }
        return num;
    }

}
