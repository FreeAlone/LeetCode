package com.exam.lc_01;

import com.exam.util.LC_Utils;
import com.exam.util.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class LC_0102 {

    public static void main(String[] args) {
        Integer[] root = {3,9,20,null,null,15,7};
        LC_0102 lc_0102 = new LC_0102();
        LC_Utils.printListList(lc_0102.levelOrder(LC_Utils.arrayToTree(root)));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode treeNode = pair.getKey();
            int level = pair.getValue();
            List<Integer> list = treeMap.getOrDefault(level, new ArrayList<>());
            list.add(treeNode.val);
            treeMap.put(level, list);
            if (treeNode.left != null) {
                queue.offer(new Pair<>(treeNode.left, level + 1));
            }
            if (treeNode.right != null) {
                queue.offer(new Pair<>(treeNode.right, level + 1));
            }
        }
        return new ArrayList<>(treeMap.values());
    }
}
