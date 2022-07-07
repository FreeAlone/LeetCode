package com.exam.lc_01;

import com.exam.util.LC_Utils;
import com.exam.util.TreeNode;

public class LC_0108 {

    public static void main(String[] args) {
        int[] nums1 = {-10,-3,0,5,9};
        int[] nums2 = {1,3};
        LC_0108 lc_0108 = new LC_0108();
        LC_Utils.printTree(lc_0108.sortedArrayToBST(nums1));
        LC_Utils.printTree(lc_0108.sortedArrayToBST(nums2));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;
        // 总是选择中间位置右边的数字作为根节点
        // int mid = (left + right + 1) / 2;
        // 选择任意一个中间位置数字作为根节点
        // Random random = new Random();
        // int mid = (left + right + random.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
