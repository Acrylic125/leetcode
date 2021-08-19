package com.acrylic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> permuted = permutations.permute(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        for (List<Integer> integers : permuted)
            System.out.println(integers);
        System.out.println("Size = " + permuted.size());
    }

    public void bindPermutation(List<List<Integer>> all,
                                int[] nums,
                                List<Integer> current) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int num = nums[i];
            LinkedList<Integer> ints = new LinkedList<>(current);
            ints.add(num);
            if (size > 1) {
                int s1 = size - 1;
                int[] newNums = new int[s1];
                int cursorIndex = 0;
                for (int j = 0; j < i; j++)
                    newNums[cursorIndex++] = nums[j];
                for (int j = i + 1; j <= s1; j++)
                    newNums[cursorIndex++] = nums[j];
                bindPermutation(all, newNums, ints);
            } else {
                all.add(ints);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new Stack<>();
        bindPermutation(permutations, nums, new LinkedList<>());
        return permutations;
    }

}
