package com.exam.lc_03;

import com.exam.util.LC_Utils;

public class LC_0344 {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        LC_0344 lc_0344 = new LC_0344();
        lc_0344.reverseString(s);
        LC_Utils.printArr(s);
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char c = s[i];
            s[i] = s[s.length - i -1];
            s[s.length - i -1] = c;
        }
    }
}
