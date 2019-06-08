package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/8
 * 搜狐
 * 回文数组
 * 对于一个给定的正整数组成的数组 a[] ，如果将 a 倒序后数字的排列与 a 完全相同，我们称这个数组为“回文”的。
 * 例如， [1, 2, 3, 2, 1] 的倒序是他自己，所以是一个回文的数组；而 [1, 2, 3, 1, 2] 的倒序是 [2, 1, 3, 2, 1] ，所以不是一个回文的数组。
 * 对于任意一个正整数数组，如果我们向其中某些特定的位置插入一些正整数，那么我们总是能构造出一个回文的数组。
 *
 * 输入一个正整数组成的数组，要求你插入一些数字，使其变为回文的数组，且数组中所有数字的和尽可能小。输出这个插入后数组中元素的和。
 *
 * 例如，对于数组 [1, 2, 3, 1, 2] 我们可以插入两个 1 将其变为回文的数组 [1, 2, 1, 3, 1, 2, 1] ，这种变换方式数组的总和最小，为 11 ，所以输出为 11 。
 */
public class Code_054 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
            sum += a[i];
        }
        int[][] dp = new int[n][n];
        for(int i=n-1;i>=0;i--){
            dp[i][i] = a[i];
            for(int j=i+1;j<n;j++){
                if(a[i]==a[j]){
                    dp[i][j] = dp[i+1][j-1] + 2*a[i];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(2*sum - dp[0][n-1]);
    }
}
