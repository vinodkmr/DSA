package com.core.java.test;

import static java.lang.Character.isUpperCase;

public class TestInt {
    public static void main(String[] args) {
        /*String str = "my name is vinod";
        StringBuilder sb = new StringBuilder();
        reverse(str.toCharArray(), sb, str.length()-1);
        System.out.println(sb);*/
//        getUnderscore();
    }

    private static void reverse(char[] chars, StringBuilder sb, int index) {
        if(index == -1) return;
        sb.append(chars[index]);
        reverse(chars,sb,--index);
    }

    //AllstateIsUsCompony —>Allstate_Is_Us_Compony
    public static void getUnderscore(){
        String str = "AllstateIsUsCompony";
        StringBuilder stringBuilder = new StringBuilder();
        for(Character character : str.toCharArray()){
            if(str.indexOf(character) != 0 && isUpperCase(character)){
                stringBuilder.append("_").append(character);
            }else{
                stringBuilder.append(character);
            }
        }
        System.out.printf(stringBuilder.toString());
    }
}
