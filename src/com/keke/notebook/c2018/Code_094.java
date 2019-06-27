package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/27
 * 美团点评
 * 数字构造
 * 对于一个十进制数而言，它的数位和等于将它各位数字相加得到的和。比如 231 的数位和 是 6，3179 的数位和是 20。
 * 现在你知道某个十进制数的数位和等于 s，并且这个数不包含 0，且任意相邻的数位是不同 的，比如 112 或者 102 都是不满足条件的。
 * 现在你想知道满足这样的条件的最大的数是多少?
 */
public class Code_094 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int r = s%3;
        s = s/3;
        if(r==1){
            System.out.print(1);
        }
        while(s-->0){
            System.out.print("21");
        }
        if(r==2){
            System.out.print(2);
        }
        System.out.println();
    }
}
