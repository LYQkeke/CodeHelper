package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/7/2
 * 招商银行信用卡
 * 序列找数
 * 从非负整数序列 0, 1, 2, ..., n中给出包含其中n个数的子序列，请找出未出现在该子序列中的那个数
 */
public class Code_127 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] nums = new boolean[n+1];
        for(int i=0;i<n;i++){
            nums[in.nextInt()]=true;
        }
        for(int i=0;i<=n;i++){
            if(!nums[i]){
                System.out.println(i);
                return;
            }
        }
    }
}
