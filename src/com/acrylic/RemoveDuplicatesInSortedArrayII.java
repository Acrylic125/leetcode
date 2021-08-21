package com.acrylic;

public class RemoveDuplicatesInSortedArrayII {

    public static void main(String[] args) {
        RemoveDuplicatesInSortedArrayII removeDuplicatesInSortedArray = new RemoveDuplicatesInSortedArrayII();
        System.out.println(removeDuplicatesInSortedArray.removeDuplicates(new int[] { 0,0,1,1,1,1,2,3,3 }));
    }

    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if (size == 0)
            return 0;
        int     currentValue = nums[0],
                nextSlot = 1,
                occurrence = 1,
                val;
        for (int i = 1; i < size; i++) {
            val = nums[i];
            if (val == currentValue && occurrence < 2) {
                occurrence++;
                nums[nextSlot++] = val;
            } else if (val > currentValue) {
                currentValue = val;
                nums[nextSlot++] = val;
                occurrence = 1;
            }
        }
        return nextSlot;
    }

}
