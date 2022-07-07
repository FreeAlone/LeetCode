package com.exam.lc_08;

import com.exam.util.LC_Utils;
import com.exam.util.TreeNode;

public class LC_0814 {

    public static void main(String[] args) {
        Integer[] root1 = {1,null,0,null,null,0,1};
        Integer[] root2 = {1,0,1,0,0,0,1};
        Integer[] root3 = {1,1,0,1,1,null,1};
        LC_0814 lc_0814 = new LC_0814();
        LC_Utils.printTree(lc_0814.pruneTree(LC_Utils.arrayToTree(root1)));
        LC_Utils.printTree(lc_0814.pruneTree(LC_Utils.arrayToTree(root2)));
        LC_Utils.printTree(lc_0814.pruneTree(LC_Utils.arrayToTree(root3)));
    }


    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (pruneTree(root.left) == null) {
            root.left = null;
        }
        if (pruneTree(root.right) == null) {
            root.right = null;
        }
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
