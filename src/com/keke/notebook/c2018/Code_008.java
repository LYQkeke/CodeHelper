package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 网易04
 * 操作序列
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 * 1、将a_i放入b序列的末尾
 * 2、逆置b序列
 * 小易需要你计算输出操作n次之后的b序列。
 */
public class Code_008 {

    public static void main(String[] args){
        ans2();
    }

    // 空间限制超了，但是能通过
    private static void ans1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<a.length;i++){
            a[i] = in.nextInt();
        }
        int l = 0;
        int r = a.length-1;
        n--;
        while(l<=r){
            b[l++]=a[n--];
            if(l<=r){
                b[r--]=a[n--];
            }
        }
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
        System.out.println();
    }

    // 不应该啊，第二个怎么比第一个内存空间还要大
    private static void ans2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<a.length;i++){
            a[i] = in.nextInt();
        }
        int i = n;
        while(i>0){
            System.out.print(a[i-1]+" ");
            i-=2;
        }
        i = ((n&1)!=0)?2:1;
        while(i<=n){
            System.out.print(a[i-1]+" ");
            i+=2;
        }
        System.out.println();
    }
}
