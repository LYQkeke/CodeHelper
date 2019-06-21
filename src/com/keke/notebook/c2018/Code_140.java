package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/21
 * 滴滴出行
 * 给定整数序列求连续子串最大和
 * 给定无序整数序列，求连续子串最大和，例如{-23 17 -7 11 -2 1 -34}，子串为{17,-7,11}，最大和为21
 */
public class Code_140 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] numStrings = in.nextLine().split(" ");
        int[] dp = new int[numStrings.length];
        dp[0] = Integer.valueOf(numStrings[0]);
        int max = dp[0];
        for(int i=1;i<dp.length;i++){
            int cur = Integer.valueOf(numStrings[i]);
            dp[i] = Math.max(dp[i-1]+cur,cur);
            max = Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}
