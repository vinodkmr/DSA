package com.core.java.leetcode;

import com.core.java.test.Test;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.core.java.test.CoreJava.twoSum;

public class LeetCode {
    public static void main(String[] args) {
//        System.out.println(isPalindrome(121));
//        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flaw"}));
//        validParantheses();
//        twoSum(new int[]{2,7,11,15}, 9);
//        deleteANumInArr(new int[]{2,7,11,15},7);
//        mergedSortedArray();
//        removeDuplicates();
        maxProfit();

    }

    private static void mergedSortedArray() {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3, n = 3;
        int[] nums2 = {2,5,6};
        int i = m, j = 0;
        while (j < n) {
            nums1[i] = nums2[j];
            System.out.println(nums2[j]);
            i++;
            j++;
        }
        Arrays.sort(nums1);
    }

    public static void removeDuplicates() {
        int[]  nums = {1,2,2};
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        int i = 0;
        nums = new int[map.size()];
        for(Integer ele : map.keySet()){
            nums[i] = map.get(ele).intValue();
            i++;
        }
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println(map.size());

    }

    private static void deleteANumInArr(int[] arr, int ele) {
        for(int i = 0; i<arr.length; i++){
//            if()
        }
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

    public static void maxProfit() {
        int[] prices = {2,4,1};
        int buyPrice = Integer.MAX_VALUE;
        int buyPriceIndex = Integer.MAX_VALUE;
        int sellPriceIndex = Integer.MAX_VALUE;

        int sellPrice = -1;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPrice && buyPriceIndex <= sellPriceIndex){
                buyPrice = prices[i];
                buyPriceIndex = i;
            }
            if (prices[i] > sellPrice && buyPriceIndex < i){
                System.out.println("index buy "+buyPriceIndex);
                sellPrice = prices[i];
                sellPriceIndex = i;
            }
            System.out.println("index "+i+" buy Index "+buyPriceIndex+" sell price index "+sellPriceIndex);
        }
        System.out.println("sell price "+sellPrice+" buy price "+buyPrice);
        int profit = sellPrice - buyPrice;
        System.out.println("Max profit ");
        System.out.println(Math.max(profit, 0));
    }
}




interface TestYo{
    void test();
    void test1(int i);
}