package com.exam.lc_00;

import com.exam.util.LC_Utils;
import com.exam.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_0094 {

    public static void main(String[] args) {
        Integer[] root = {1,null,2,null,null,3};
        LC_0094 lc_0094 = new LC_0094();
        LC_Utils.printList(lc_0094.inorderTraversal(LC_Utils.arrayToTree(root)));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        visit(root, list);
        return list;
    }

    public void visit(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        visit(treeNode.left, list);
        list.add(treeNode.val);
        visit(treeNode.right, list);
    }
}
