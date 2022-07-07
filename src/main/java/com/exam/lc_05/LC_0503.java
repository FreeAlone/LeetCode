package com.exam.lc_05;

import com.exam.util.LC_Utils;

import java.util.*;

public class LC_0503 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        LC_0503 lc_0503 = new LC_0503();
        LC_Utils.printArr(lc_0503.nextGreaterElements(nums));
    }


    public int[] nextGreaterElements(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(i);
        }
        boolean[] visited = new boolean[nums.length];
        boolean[] inStack = new boolean[nums.length];
        int[] result = new int[nums.length];
        int temp = 0;
        Stack<Integer> stack = new Stack<>();
        while (temp != nums.length) {
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    int index = stack.pop();
                    inStack[index] = false;
                    if (!visited[index]) {
                        result[index] = nums[i];
                        visited[index] = true;
                        set.remove(index);
                        temp++;
                    }
                }
                if (!inStack[i] && !visited[i]) {
                    stack.push(i);
                    inStack[i] = true;
                }
            }
            if (judge(set, nums)) {
                while (!stack.isEmpty()) {
                    int index = stack.pop();
                    result[index] = -1;
                    visited[index] = true;
                    inStack[index] = false;
                    set.remove(index);
                    temp++;
                }
            }
        }
        return result;

    }

    public boolean judge(TreeSet<Integer> set, int[] nums) {
        if (set == null || set.size() <= 1) {
            return true;
        }
        int flag = nums[set.first()];
        for (Integer integer : set) {
            if (flag != nums[integer]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 官方答案
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }

}
