package com.keke.notebook.c2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 爱奇艺
 * 排序
 * 牛牛有一个长度为n的整数序列,牛牛想对这个序列进行重排为一个非严格升序序列。
 * 牛牛比较懒惰,他想移动尽量少的数就完成重排,请你帮他计算一下他最少需要移动多少个序列中的元素。
 * (当一个元素不在它原来所在的位置,这个元素就是被移动了的)
 */
public class Code_019 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] x = new int[n];
            for(int i=0;i<n;i++){
                x[i] = in.nextInt();
            }
            int[] x1 = Arrays.copyOf(x,x.length);
            Arrays.sort(x);
            int count = 0;
            for(int i=0;i<n;i++){
                if(x[i]!=x1[i])
                    count++;
            }
            System.out.println(count);
        }
    }
}
