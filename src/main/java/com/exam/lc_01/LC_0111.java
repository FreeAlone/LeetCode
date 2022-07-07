package com.exam.lc_01;

import com.exam.util.LC_Utils;
import com.exam.util.TreeNode;

public class LC_0111 {

    public static void main(String[] args) {
        Integer[] root = {3,9,20,null,null,15,7};
        LC_0111 lc_0111= new LC_0111();
        System.out.println(lc_0111.minDepth(LC_Utils.arrayToTree(root)));
    }

    public int minDepth(TreeNode root) {
        return dfs(root, 0, Integer.MAX_VALUE);
    }

    public int dfs (TreeNode treeNode, int depth, int min) {
        depth++;
        if (treeNode.left == null && treeNode.right == null) {
            min = Math.min(depth, min);
        }
        if (treeNode.left != null) {
            min = dfs(treeNode.left, depth, min);
        }
        if (treeNode.right != null) {
            min = dfs(treeNode.right, depth, min);
        }
        return min;
    }



}
