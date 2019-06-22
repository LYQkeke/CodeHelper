package com.keke.notebook.huawei;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/22
 * 质数因子
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 */
public class Code_006 {

    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        long n = in.nextLong();
        long cur = 2;
        while (n!=1){
            if (n%cur==0){
                System.out.print(cur+" ");
                n = n/cur;
            }else {
                cur = next(cur);
            }
        }
        System.out.println();
    }

    public static long next(long cur){
        long next = cur + 1;
        int i = 2;
        while(i<=Math.sqrt(next)){
            if(next%i==0){
                i = 2;
                ++next;
            }else{
                ++i;
            }
        }
        return next;
    }
}
