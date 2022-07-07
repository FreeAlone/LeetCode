package com.exam.lc_02;

import com.exam.util.LC_Utils;
import com.exam.util.TreeNode;

public class LC_0226 {

    public static void main(String[] args) {
        LC_0226 lc_0226 = new LC_0226();
        Integer[] nums = {};
        TreeNode treeNode = lc_0226.invertTree(LC_Utils.arrayToTree(nums));
        LC_Utils.printTree(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
