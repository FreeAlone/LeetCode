package com.exam.lc_02;

import com.exam.util.LC_Utils;
import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class LC_0239 {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] nums1 = {1};
        int k1 = 1;
        LC_0239 lc_0239 = new LC_0239();
        LC_Utils.printArr(lc_0239.maxSlidingWindow(nums, k));
        LC_Utils.printArr(lc_0239.maxSlidingWindow(nums1, k1));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Pair<Integer, Integer>> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast().getValue() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(new Pair<>(i, nums[i]));
            if (i - k + 1 >= 0) {
                if (deque.peekFirst().getKey() == i - k) {
                    deque.pollFirst();
                }
                res[i - k + 1] = deque.peekFirst().getValue();
            }
        }
        return res;
    }
}
