package com.exam.lc_01;

import com.exam.util.LC_Utils;
import com.exam.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_0114 {

    public static void main(String[] args) {
        Integer[] root1 = {1,2,5,3,4,null,6};
        Integer[] root2 = {};
        Integer[] root3 = {0};
        TreeNode node1 = LC_Utils.arrayToTree(root1);
        TreeNode node2 = LC_Utils.arrayToTree(root2);
        TreeNode node3 = LC_Utils.arrayToTree(root3);
        LC_0114 lc_0114 = new LC_0114();
        lc_0114.flatten(node1);
        lc_0114.flatten(node2);
        lc_0114.flatten(node3);
        LC_Utils.printTree(node1);
        LC_Utils.printTree(node2);
        LC_Utils.printTree(node3);
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode temp = list.get(i - 1);
            temp.right = list.get(i);
            temp.left = null;
        }
    }

    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
