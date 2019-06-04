package com.keke.notebook.c2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/4
 * 爱奇艺
 * 冒泡排序
 * 牛牛学习了冒泡排序,并写下以下冒泡排序的伪代码,注意牛牛排序的数组a是从下标0开始的。
 * BubbleSort(a):
 *      Repeat length(a)-1 times:
 *          For every i from 0 to length(a) - 2:
 *              If a[i] > a[i+1] then:
 *                  Swap a[i] and a[i+1]
 * 牛牛现在要使用上述算法对一个数组A排序。
 * 在排序前牛牛允许执行最多k次特定操作(可以不使用完),每次特定操作选择一个连续子数组,然后对其进行翻转,并且k次特定操作选择的子数组不相交。
 * 例如A = {1, 2, 3, 4, 5, 6, 7}, k = 1,如果牛牛选择的子数组是[2,4](注意下标从0开始),那么翻转之后的数组变为A = {1, 2, 5, 4, 3, 6, 7}。
 * 牛牛知道冒泡排序的效率一定程度上取决于Swap操作次数,牛牛想知道对于一个数组A在进行k次特定操作之后,再进行上述冒泡排序最少的Swap操作次数是多少?
 */
public class Code_032 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j] = dp[i-1][j];
                for(int z=i;z>0;z--){
                    int[] temp = Arrays.copyOfRange(a,z-1,i);
                    dp[i][j] = Math.max(dp[i][j],reversePairs(temp)-reversePairs(reverse(temp))+dp[z-1][j-1]);
                }
            }
        }
        System.out.println(reversePairs(a)-dp[n][k]);
    }

    public static int[] reverse(int[] arr){
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return arr;
    }

    public static int reversePairs(int[] arr){
        int ans = 0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}
