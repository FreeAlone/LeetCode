package com.exam.lc_00;

public class LC_0035 {

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,6};
        int target1 = 5;
        int[] nums2 = {1,3,5,6};
        int target2 = 2;
        int[] nums3 = {1,3,5,6};
        int target3 = 7;
        LC_0035 lc_0035 = new LC_0035();
        System.out.println(lc_0035.searchInsert(nums1, target1));
        System.out.println(lc_0035.searchInsert(nums2, target2));
        System.out.println(lc_0035.searchInsert(nums3, target3));
    }

    public int searchInsert(int[] nums, int target) {
        int left = -1;
        int right  = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
