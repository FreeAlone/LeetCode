package com.exam.lc_09;

import com.exam.util.LC_Utils;
import com.exam.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC_0971 {

    public static void main(String[] args) {
        Integer[] root1 = {1,2};
        int[] voyage1 = {2,1};
        Integer[] root2 = {1,2,3};
        int[] voyage2 = {1,3,2};
        Integer[] root3 = {1,2,3};
        int[] voyage3 = {1,2,3};

        LC_0971 lc_0971 = new LC_0971();
        LC_Utils.printList(lc_0971.flipMatchVoyage(LC_Utils.arrayToTree(root1), voyage1));
        LC_Utils.printList(lc_0971.flipMatchVoyage(LC_Utils.arrayToTree(root2), voyage2));
        LC_Utils.printList(lc_0971.flipMatchVoyage(LC_Utils.arrayToTree(root3), voyage3));
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();
        List<Integer> total = new ArrayList<>();

        boolean res = flip(list, total, root, voyage);
        if (!res) {
            list.clear();
            list.add(-1);
        }
        return list;
    }

    public boolean flip(List<Integer> list, List<Integer> total, TreeNode root, int[] voyage) {
        if (root == null) {
            return true;
        }
        int base = voyage[total.size()];
        if (root.val != base) {
            return false;
        }
        total.add(root.val);
        if (flip(list, total, root.left, voyage) && flip(list, total, root.right, voyage)) {
            return true;
        } else if (flip(list, total, root.right, voyage) && flip(list, total, root.left, voyage)){
            list.add(root.val);
            return true;
        } else {
            return false;
        }
    }
}
