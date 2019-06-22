package com.keke.notebook.huawei;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/22
 * 求int型数据在内存中存储时1的个数
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 */
public class Code_015 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        while(n!=0){
            if((n&1)!=0){
                count++;
            }
            n = n>>>1;
        }
        System.out.println(count);
    }
}
