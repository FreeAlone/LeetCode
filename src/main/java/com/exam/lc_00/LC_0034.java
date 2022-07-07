package com.exam.lc_00;

import com.exam.util.LC_Utils;

public class LC_0034 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        LC_0034 lc_0034 = new LC_0034();
        LC_Utils.printArr(lc_0034.searchRange(nums, target));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = -1;
        int right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right <= nums.length - 1 && nums[right] == target) {
            result[0] = right;
        }
        left = -1;
        right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (left >= 0 && nums[left] == target) {
            result[1] = left;
        } else if (result[0] > -1) {
            result[1] = result[0];
        }
        return result;
    }

}
