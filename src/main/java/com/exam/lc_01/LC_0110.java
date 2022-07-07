package com.exam.lc_01;

import com.exam.util.LC_Utils;
import com.exam.util.TreeNode;

public class LC_0110 {

    public static void main(String[] args) {
        Integer[] root1 = {3,9,20,null,null,15,7};
        Integer[] root2 = {1,2,2,3,3,null,null,4,4};
        Integer[] root3 = {};
        LC_0110 lc_0110 = new LC_0110();
        System.out.println(lc_0110.isBalanced(LC_Utils.arrayToTree(root1)));
        System.out.println(lc_0110.isBalanced(LC_Utils.arrayToTree(root2)));
        System.out.println(lc_0110.isBalanced(LC_Utils.arrayToTree(root3)));

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        if (Math.abs(l - r) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(treeNode.left), getHeight(treeNode.right));
    }

}
