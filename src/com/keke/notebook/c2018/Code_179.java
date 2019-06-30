package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/30
 * 去哪儿
 * 乘方取模
 * 给定非负整数a, b, m,利用基本的算术运算符以及位运算符，计算a^b  mod m
 */
public class Code_179 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long m = in.nextLong();
        long multi = a;
        long ans = 1;
        while (b!=0){
            if((b&1)!=0){
                ans = ans*multi%m;
            }
            multi = multi*multi%m;
            b = b>>>1;
        }
        System.out.println(ans);
    }
}
