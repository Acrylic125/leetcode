package com.acrylic;

public class RaindropCollector {

    public static void main(String[] args) {
        RaindropCollector collector = new RaindropCollector();
        System.out.println(collector.trap(new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 }));
        System.out.println(collector.trap(new int[] { 4,2,0,3,2,5 }));
        System.out.println(collector.trap(new int[] { 0,1,2,3,0,0,1,0,2,1,2,0,0,1,0 }));
        System.out.println(collector.trap(new int[] { 5, 4, 1, 2 }));
    }

    public int trap(int[] height) {
        int accum = 0, size = height.length;
        for (int i = 0; i < size - 1; i++) {
            int heightI = height[i];
            int heightINext = height[i + 1];
            if (heightI > heightINext) {
                int greatestHeight = 0;
                int greatestHeightIndex = heightI;
                int heightObstaclesTotal = 0, heightObstaclesTotalAfter = 0;
                for (int j = i + 1; j < size; j++) {
                    int heightJ = height[j];
                    if (heightJ >= heightI) {
                        greatestHeight = heightJ;
                        greatestHeightIndex = j;
                        heightObstaclesTotalAfter = 0;
                        break;
                    } else if (heightJ >= greatestHeight) {
                        greatestHeight = heightJ;
                        greatestHeightIndex = j;
                        heightObstaclesTotalAfter = 0;
                    }
                    heightObstaclesTotalAfter += heightJ;
                    heightObstaclesTotal += heightJ;
                }
                if (greatestHeight > 0) {
                    int mHeight = Math.min(heightI, greatestHeight);
                    heightObstaclesTotal -= heightObstaclesTotalAfter;
                    int fill = (((greatestHeightIndex - (i + 1)) * mHeight) - heightObstaclesTotal);
                    accum += fill;
                    i = greatestHeightIndex - 1;
                }
            }
        }
        return accum;
    }
}
