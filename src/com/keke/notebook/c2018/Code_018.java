package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 爱奇艺
 * 回文素数
 * 如果一个整数只能被1和自己整除,就称这个数是素数。
 * 如果一个数正着反着都是一样,就称为这个数是回文数。例如:6, 66, 606, 6666
 * 如果一个数字既是素数也是回文数,就称这个数是回文素数
 * 牛牛现在给定一个区间[L, R],希望你能求出在这个区间内有多少个回文素数。
 */
public class Code_018 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int l = in.nextInt();
            int r = in.nextInt();
            int count = 0;
            for(int i=l;i<=r;i++){
                if(isPrime(i)&&isPalin(i))
                    count++;
            }
            System.out.println(count);
        }
    }

    private static boolean isPrime(int num){
        if(num==1)
            return false;
        for(int i=2;i<=num/2;i++){
            if(num%i==0)
                return false;
        }
        return true;
    }

    private static boolean isPalin(int num){
        char[] chs = Integer.toString(num).toCharArray();
        if(chs.length==1)
            return true;
        int l = 0;
        int r = chs.length-1;
        while(l<r){
            if(chs[l++]!=chs[r--]){
                return false;
            }
        }
        return true;
    }
}
