package com.exam.lc_00;

import com.exam.util.LC_Utils;
import com.exam.util.TreeNode;

public class LC_0098 {

    public static void main(String[] args) {
        Integer[] root = {2,1,3};
        Integer[] root1 = {5,1,4,null,null,3,6};
        LC_0098 lc_0098 = new LC_0098();
        System.out.println(lc_0098.isValidBST(LC_Utils.arrayToTree(root)));
        System.out.println(lc_0098.isValidBST(LC_Utils.arrayToTree(root1)));
    }

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    public void dfs(TreeNode treeNode, boolean flag, int val) {

    }
}
