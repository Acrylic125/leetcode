package com.acrylic;

// https://leetcode.com/problems/search-insert-position/
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(new int[] { 1,3,5,6 }, 5));
    }

    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        int mid = (size % 2 == 0 ? 1 : 0) + (size / 2);
        int foundIndex = -1;
        for (int i = 0; i < mid; i++) {
            int low = nums[i];
            if (foundIndex == -1) {
                System.out.println("High : " + (size - i - 1));
                int high = nums[size - i - 1];
                if (high == target)
                    return size - i - 1;
            }
            if (low == target)
                foundIndex = low;
            if (low < target)
                return (foundIndex == -1) ? 0 : foundIndex;
        }
        return (foundIndex == -1) ? 0 : foundIndex;
    }

}
