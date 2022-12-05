package com.acrylic;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] arr = { 0,1,2,2,3,0,4,2 };
        System.out.println(removeElement.removeElement(arr, 2));
        System.out.println(Arrays.toString(arr));
    }

    public int removeElement(int[] nums, int val) {
        int nextSlot = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != val) {
                nums[nextSlot] = num;
                nextSlot++;
            }
        }
        return nextSlot;
    }
}
