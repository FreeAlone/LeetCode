package com.exam.lc_01;

public class LC_0125 {

    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "0P";
        LC_0125 lc_0125 = new LC_0125();
        System.out.println(lc_0125.isPalindrome(str1));
        System.out.println(lc_0125.isPalindrome(str2));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if ((c >= 'a' && c <= 'z') || (c >= 0 && c <= 9)) {
                sb.append(c);
            }
        }
        if (sb.length() == 0) {
            return true;
        }
        char[] resArr = sb.toString().toCharArray();
        for (int i = 0; i < resArr.length/2; i++) {
            if (resArr[i] != resArr[resArr.length - i -1]) {
                return false;
            }
        }
        return true;
    }
}
