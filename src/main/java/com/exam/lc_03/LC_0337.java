package com.exam.lc_03;

import com.exam.util.LC_Utils;
import com.exam.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC_0337 {

    public static void main(String[] args) {
        Integer[] root1 = {3,2,3,null,3,null,1};
        Integer[] root2 = {3,4,5,1,3,null,1};
        LC_0337 lc_0337 = new LC_0337();
        System.out.println(lc_0337.rob(LC_Utils.arrayToTree(root1)));
        System.out.println(lc_0337.rob(LC_Utils.arrayToTree(root2)));
    }

    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        return Math.max(dfs(root), dfs(root.left) + dfs(root.right));
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.get(root) != null) {
            return map.get(root);
        }
        int val = root.val;
        if (root.left != null) {
            val += dfs(root.left.left) + dfs(root.left.right);
        }
        if (root.right != null) {
            val += dfs(root.right.left) + dfs(root.right.right);
        }
        int value = dfs(root.left) + dfs(root.right);
        int max = Math.max(val, value);
        map.put(root, max);
        return max;
    }
}
