package com.exam.lc_02;

import com.exam.util.LC_Utils;

public class LC_0238 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {0,0};
        LC_0238 lc_0238 = new LC_0238();
        LC_Utils.printArr(lc_0238.productExceptSelf2(nums1));
        LC_Utils.printArr(lc_0238.productExceptSelf(nums2));
    }

    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        right[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }
        int[] ret = new int[len];
        ret[0] = right[1];
        ret[len - 1] = left[len - 2];
        for (int i = 1; i < len - 1; i++) {
            ret[i] = left[i - 1] * right[i + 1];
        }
        return ret;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int temp = 0;
        int index = -1;
        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                temp++;
                index = i;
                continue;
            }
            sum *= nums[i];
        }
        if (temp > 1) {
            return ret;
        }
        if (index > -1) {
            ret[index] = sum;
        } else {
            for (int i = 0; i < nums.length; i++) {
                ret[i] = sum / nums[i];
            }
        }
        return ret;
    }
}
