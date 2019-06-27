package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/27
 * 美团点评
 * 最小排列
 * 由数字 1 到 n 组成的一个序列我们称为一个 n 排列。
 * 对于两个不同的 n 排列𝐴 = 𝑎1𝑎2 ... 𝑎𝑛和 𝐵 = 𝑏1𝑏2 ... 𝑏𝑛我们可以按字典序比较他们的大小:从前往后找到第一个两个排列中数字不同 的位置，
 * 即找到一个位置𝑝使得𝑎1 = 𝑏1, 𝑎2 = 𝑏2, ... , 𝑎𝑝−1 = 𝑏𝑝−1, 𝑎𝑝 ≠ 𝑏𝑝，若𝑎𝑝 < 𝑏𝑝，我们 则称排列𝐴小于排列𝐵，反之则𝐴大于𝐵。现在给出一个 n 排列，
 * 你需要选择排列中的两个不同的位置，然后交换这两个位置的数字， 你需要使得最后得到的排列尽量小。
 * 注意你必须进行一次且只能进行一次操作。
 */
public class Code_093 {

    public static void main(String[] args){
        /**
         * 必须要交换一次，如果不能变得更小，那么交换最后两个数字
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        int min = n-1;
        int replace1 = -1;
        int replace2 = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[min]){
                replace1 = i;
                replace2 = min;
            }else if(nums[i]<nums[min]){
                min = i;
            }
        }
        if(replace1==-1){
            replace1 = n - 2;
            replace2 = n - 1;
        }
        int temp = nums[replace1];
        nums[replace1] = nums[replace2];
        nums[replace2] = temp;
        for(int i=0;i<n;i++){
            if(i!=0){
                System.out.print(" ");
            }
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}
