package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/11
 * 搜狐畅游
 * 第二大的数
 * 输入n个整数，查找数组中第二大的数
 */
public class Code_068 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;
        while(in.hasNext()){
            int temp = in.nextInt();
            if(temp>num1){
                num2 = num1;
                num1 = temp;
            }else if(temp>num2){
                num2 = temp;
            }
        }
        System.out.println(num2);
    }
}
