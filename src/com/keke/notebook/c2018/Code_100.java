package com.keke.notebook.c2018;

import java.util.*;

/**
 * Created by KEKE on 2019/6/26
 * 吉比特：最大差值
 * 给定一个未排序的数列，找到此数列在已排序状态下的两个相邻值的最大差值，少于两个值时返回0。
 * 例如：给定数列 [1,3,2,0,1,6,8] 则 最大差值为3。注意：请尽量使用时间复杂度为O(n)的方案。
 * 桶排序
 */
public class Code_100 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] numsStr = in.nextLine().split(" ");
        int[] nums = new int[numsStr.length];
        for (int i=0;i<nums.length;i++){
            nums[i] = Integer.valueOf(numsStr[i]);
        }
        backetSort(nums);
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans,nums[i]-nums[i-1]);
        }
        System.out.println(ans);
    }

    private static void backetSort(int[] arr){
        List[] backets = new List[10];
        for (int i = 0; i < 10; i++) {
            backets[i] = new ArrayList<Integer>();
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        int backetSize = (max-min)/10;
        if (backetSize<1){
            backetSize = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            int no = (arr[i]-min)/backetSize;
            if (no>9)
                no = 9;
            backets[no].add(arr[i]);
        }
        int index = 0;
        for (int i = 0; i < 10; i++) {
            Collections.sort(backets[i]);
            Iterator iterator = backets[i].iterator();
            while (iterator.hasNext()){
                arr[index++] = (int)iterator.next();
            }
        }
    }
}
