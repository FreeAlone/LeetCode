package com.exam.lc_04;

import com.exam.util.LC_Utils;

import java.util.Stack;
import java.util.TreeMap;

public class LC_0496 {

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {7,5,4,6};
        int[] nums11 = {2,4};
        int[] nums22 = {1,2,3,4};

        LC_0496 lc_0496 = new LC_0496();
        LC_Utils.printArr(lc_0496.nextGreaterElement(nums1, nums2));
        LC_Utils.printArr(lc_0496.nextGreaterElement(nums11, nums22));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                treeMap.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        int[] nums = new int[nums1.length];
        for (int i = nums1.length - 1; i >= 0; i--) {
            nums[i] = treeMap.getOrDefault(nums1[i], -1);
        }
        return nums;
    }
}
