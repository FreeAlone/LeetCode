package com.exam.lc_09;

import com.exam.util.LC_Utils;
import com.exam.util.TreeNode;

public class LC_0979 {

    public static void main(String[] args) {
        Integer[] root1 = {3,0,0};
        Integer[] root2 = {0,3,0};
        Integer[] root3 = {1,0,2};
        Integer[] root4 = {1,0,0,null,3};
        LC_0979 lc_0979 = new LC_0979();
        System.out.println(lc_0979.distributeCoins(LC_Utils.arrayToTree(root1)));
        System.out.println(lc_0979.distributeCoins(LC_Utils.arrayToTree(root2)));
        System.out.println(lc_0979.distributeCoins(LC_Utils.arrayToTree(root3)));
        System.out.println(lc_0979.distributeCoins(LC_Utils.arrayToTree(root4)));
    }

    int ans = 0;

    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = ans + Math.abs(left) + Math.abs(right);
        return root.val + left + right -1;
    }
}
