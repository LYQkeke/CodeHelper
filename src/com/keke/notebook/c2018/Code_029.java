package com.keke.notebook.c2018;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by KEKE on 2019/5/31
 * 爱奇艺
 * 幸运子序列
 * 牛牛得到一个长度为n的整数序列V,牛牛定义一段连续子序列的幸运值为这段子序列中最大值和次大值的异或值(次大值是严格的次大)。
 * 牛牛现在需要求出序列V的所有连续子序列中幸运值最大是多少。请你帮帮牛牛吧。
 * 单调栈
 */
public class Code_029 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] v = new int[n];
        for(int i=0;i<n;i++){
            v[i] = in.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int temp = 0;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&stack.peek()<=v[i]){
                temp = stack.pop();
                if(temp<v[i]){
                    max = Math.max(max,temp^v[i]);
                    if(!stack.isEmpty()){
                        max = Math.max(max,temp^stack.peek());
                    }
                }
            }
            stack.push(v[i]);
        }
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(!stack.isEmpty()){
                max = Math.max(max,stack.peek()^temp);
            }
        }
        System.out.println(max);
    }
}
