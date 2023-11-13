package com.core.java.leetcode;

import static com.core.java.test.CoreJava.twoSum;

public class LeetCode {
    public static void main(String[] args) {
//        System.out.println(isPalindrome(121));
//        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flaw"}));
//        validParantheses();
        twoSum(new int[]{2,7,11,15}, 9);
    }

    private static void validParantheses() {
        String s = "()[]{}";
        for (int i = 0; i < s.length(); i = i + 2) {
            int j = i;
            char c = s.charAt(i);
            if (s.charAt(i) == '(' && s.charAt(++j) != ')'){
                System.out.println(false);
                break;

            }
            if (s.charAt(i) == '[' && s.charAt(++j) != ']'){
                System.out.println(false);
                break;

            }
            if (s.charAt(i) == '{' && s.charAt(++j) != '}'){
                System.out.println(false);
                break;
            }
        }
    }

    private static String longestCommonPrefix(String[] strs){
        if(strs.length == 0) return "";

        String prefix = strs[0];
        for(int i = 1; i<strs.length; i++){
            while (!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }

    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        char[] charArr = str.toCharArray();
        for (int i = charArr.length-1; i >= 0; i--) {
            char c = charArr[i];
            System.out.println(c);
            sb.append(c);

        }
        System.out.println(sb);
        return sb.toString().equals(str);
    }
}