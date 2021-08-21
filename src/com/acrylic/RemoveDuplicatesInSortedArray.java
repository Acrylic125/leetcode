package com.acrylic;

public class RemoveDuplicatesInSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesInSortedArray removeDuplicatesInSortedArray = new RemoveDuplicatesInSortedArray();
        System.out.println(removeDuplicatesInSortedArray.removeDuplicates(new int[] { }));
    }

    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if (size == 0)
            return 0;
        int     currentValue = nums[0],
                nextSlot = 1;
        for (int i = 1; i < size; i++) {
            int val = nums[i];
            if (val > currentValue) {
                currentValue = val;
                nums[nextSlot] = val;
                nextSlot++;
            }
        }
        return nextSlot;
    }

}
