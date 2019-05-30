package com.keke.notebook.c2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 网易07
 * 疯狂队列
 * 小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。
 * 有一次,n个学生在列队的时候,小易老师正好去卫生间了。
 * 学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。
 * 由于按照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯狂值最大的顺序来进行列队。
 * 现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。小易老师回来一定会气得半死。
 */
public class Code_011 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<arr.length;i++){
                arr[i] = in.nextInt();
            }
            getMax(arr);
        }
    }

    private static void getMax(int[] arr){
        if(arr.length==1){
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int min = arr[0];
        int crazy = max - min;
        int nextMin = 1;
        int nextMax = arr.length-2;
        while(nextMin<nextMax){
            crazy += max - arr[nextMin];
            crazy += arr[nextMax] - min;
            min = arr[nextMin++];
            max = arr[nextMax--];
        }
        if(nextMin==nextMax){
            crazy += Math.max(max-arr[nextMin],arr[nextMax]-min);
        }
        System.out.println(crazy);
    }
}
