package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/3
 * 爱奇艺
 * 平方串 -- 枚举分割位置 --> LCSequence
 * 如果一个字符串S是由两个字符串T连接而成,即S = T + T, 我们就称S叫做平方串,例如"","aabaab","xxxx"都是平方串.
 * 牛牛现在有一个字符串s,请你帮助牛牛从s中移除尽量少的字符,让剩下的字符串是一个平方串。换句话说,就是找出s的最长子序列并且这个子序列构成一个平方串。
 */
public class Code_035 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if(input.length()==1){
            System.out.println(0);
            return;
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<input.length();i++){
            max = Math.max(max,lcsequence(input.substring(0,i),input.substring(i,input.length())));
        }
        System.out.println(max*2);
    }

    private static int lcsequence(String str1, String str2){
        int[][] dp = new int[str1.length()][str2.length()];
        dp[0][0] = str1.charAt(0)==str2.charAt(0)?1:0;
        for(int i=1;i<str2.length();i++){
            dp[0][i] = Math.max(dp[0][i-1],str1.charAt(0)==str2.charAt(i)?1:0);
        }
        for(int i=1;i<str1.length();i++){
            dp[i][0] = Math.max(dp[i-1][0],str1.charAt(i)==str2.charAt(0)?1:0);
        }
        for(int i=1;i<str1.length();i++){
            for(int j=1;j<str2.length();j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }
        return dp[str1.length()-1][str2.length()-1];
    }
}
