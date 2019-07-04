package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/7/4
 * 招商银行信用卡
 * 字符串是否由子串拼接
 * 给出一个非空的字符串，判断这个字符串是否是由它的一个子串进行多次首尾拼接构成的。
 * 例如，"abcabcabc"满足条件，因为它是由"abc"首尾拼接而成的，而"abcab"则不满足条件。
 */
public class Code_135 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int mid = s.length()/2;
        boolean find = false;
        String ans = "";
        for(int i=0;i<mid;i++){
            String cur = s.substring(0,i+1);
            if(s.replaceAll(cur,"").length()==0){
                ans = cur;
                find = true;
            }
        }
        System.out.println(find?ans:"false");
    }
}
