package com.keke.notebook.c2018;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/12
 * 网易
 * 最小众倍数
 * 给定5个正整数, 它们的最小的众倍数是指的能够被其中至少三个数整除的最小正整数。 给定5个不同的正整数, 请计算输出它们的最小众倍数。
 */
public class Code_069 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = new int[5];
        for(int i=0;i<5;i++){
            nums[i] = in.nextInt();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = 1;
        while (n>0){
            for(int i=0;i<5;i++){
                int temp = nums[i]*n;
                if (!map.containsKey(temp)){
                    map.put(temp,1);
                }else if(map.get(temp)==2){
                    System.out.println(temp);
                    return;
                }else {
                    map.put(temp,map.get(temp)+1);
                }
            }
            n++;
        }
    }
}
