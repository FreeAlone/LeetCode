package com.exam.lc_03;

import java.util.HashMap;
import java.util.Map;

public class LC_0387 {
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";
        LC_0387 lc_0387 = new LC_0387();
        System.out.println(lc_0387.firstUniqChar(s1));
        System.out.println(lc_0387.firstUniqChar(s2));
        System.out.println(lc_0387.firstUniqChar(s3));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            Integer num = map.getOrDefault(c, 0);
            map.put(c, num + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            Integer res = map.get(arr[i]);
            if (res == 1) {
                return i;
            }
        }
        return -1;
    }
}
