package com.acrylic;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[] { 1,8,6,2,5,4,8,3,7 }));
        System.out.println(containerWithMostWater.maxArea(new int[] { 1,1 }));
        System.out.println(containerWithMostWater.maxArea(new int[] { 1, 2, 1 }));
        System.out.println(containerWithMostWater.maxArea(new int[] { 2,3,4,5,18,17,6 }));
        System.out.println(containerWithMostWater.maxArea(new int[] { 4,3,2,1,4 }));
    }

    public int maxArea(int[] height) {
        int size = height.length;
        int highestArea = 0;
        for (int i = size - 1; i >= 0; i--) {
            int iHeight = height[i];
            for (int j = 0; j < i; j++) {
                int area = Math.min(iHeight, height[j]) * (i - j);
                if (area > highestArea) {
                    highestArea = area;
                }
            }
        }
        return highestArea;
    }

}
