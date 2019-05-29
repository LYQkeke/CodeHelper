package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/29
 * 拼多多01
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 */
public class Code_001 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<a.length;i++){
            a[i] = in.nextInt();
        }
        maxMul(a);
    }

    private static void maxMul(int[] arr){
        long max1=0,max2=0,max3=0;
        long min1=0,min2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max1){
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            }else if(arr[i]>max2){
                max3 = max2;
                max2 = arr[i];
            }else if(arr[i]>max3){
                max3 = arr[i];
            }
            if(arr[i]<min1){
                min2 = min1;
                min1 = arr[i];
            }else if(arr[i]<min2){
                min2 = arr[i];
            }
        }
        System.out.println(Math.max(max1*max2*max3,max1*min1*min2));
    }
}
