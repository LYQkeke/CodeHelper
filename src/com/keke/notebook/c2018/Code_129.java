package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/7/2
 * 招商银行信用卡
 * 不想出差的HR
 * 按照卡中心校园招聘的要求，HR小招和小商需要从三个科室中（分别为A、B、C）抽派面试官去往不同城市。
 * 两名HR按照以下规定轮流从任一科室选择面试官：每次至少选择一位，至多选择该科室剩余面试官数。
 * 最先选不到面试官的HR需要自己出差。
 * 假设HR小招和小商都不想出差且每次选择都采取最优策略，如果是小招先选，写一个函数来判断她是否需要出差。
 * 如果不需要出差，请给出第一步的最优策略。
 */
public class Code_129 {

    // 尼姆博弈
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(",");
        int[] nums = new int[strs.length];
        int k = 0;
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
            k ^= nums[i];
        }
        if(k==0){
            // P格局先手必败
            System.out.println(1);
        }else{
            // N格局先手必胜
            // 找到将N格局转换为P格局的方式
            for(int i=0;i<nums.length;i++){
                // 找到使得异或和为0的一种方式
                int temp = k^nums[i];
                if(nums[i]-temp>=0){
                    System.out.println((char)(i+'A')+","+(nums[i]-temp));
                    break;
                }
            }
        }
    }
}
