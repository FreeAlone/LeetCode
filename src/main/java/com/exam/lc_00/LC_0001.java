package com.exam.lc_00;

import com.exam.util.LC_Utils;

public class LC_0001 {

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        int[] nums2 = {3,2,4};
        int target2 = 6;
        int[] nums3 = {3,3};
        int target3 = 6;
        LC_0001 lc_0001 = new LC_0001();
        LC_Utils.printArr(lc_0001.twoSum(nums1, target1));
        LC_Utils.printArr(lc_0001.twoSum(nums2, target2));
        LC_Utils.printArr(lc_0001.twoSum(nums3, target3));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
