package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 爱奇艺
 * 字符串价值
 * 有一种有趣的字符串价值计算方式:统计字符串中每种字符出现的次数,然后求所有字符次数的平方和作为字符串的价值
 * 例如: 字符串"abacaba",里面包括4个'a',2个'b',1个'c',于是这个字符串的价值为4 * 4 + 2 * 2 + 1 * 1 = 21
 * 牛牛有一个字符串s,并且允许你从s中移除最多k个字符,你的目标是让得到的字符串的价值最小。
 */
public class Code_020 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String input = in.next();
            int k = in.nextInt();
            int[] counter = new int[26];
            int[] times = new int[51];
            int ans = 0;
            for(int i=0;i<input.length();i++){
                counter[input.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++){
                if(counter[i]!=0){
                    times[counter[i]]++;
                }
            }
            for(int i=50;i>0;i--){
                while(times[i]>0&&k>0){
                    k--;
                    times[i]--;
                    times[i-1]++;
                }
            }
            for(int i=1;i<=50;i++){
                if(times[i]!=0){
                    ans += i*i*times[i];
                }
            }
            System.out.println(ans);
        }
    }
}
