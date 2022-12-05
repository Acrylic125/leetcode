package com.acrylic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraySumTarget {

    public static void main(String[] args) {
        int[] arr = { 2, 5, 4, 1, 3, 71 };
        int target = 8;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // Num Needed to index binding.
        final Map<Integer, Integer> binding = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            binding.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int need = target - current;
            Integer needIndex = binding.get(need);
            if (needIndex != null && i != needIndex) {
                return new int[]{ i, needIndex };
            }
        }
        return new int[] {};
    }

}
