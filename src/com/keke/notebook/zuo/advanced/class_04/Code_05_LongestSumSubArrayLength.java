package com.keke.notebook.zuo.advanced.class_04;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by KEKE on 2019/5/30
 * 给定一个数组arr， 和一个整数num， 求在arr中， 累加和等于num的最长
 * 子数组的长度
 * 例子：
 * arr = {7,3,2,1,1,7,7,7} num = 7
 * 其中有很多的子数组累加和等于7， 但是最长的子数组是{3,2,1,1}， 所
 * 以返回其长度4
 */
public class Code_05_LongestSumSubArrayLength {

    public static int maxLength(int[] arr, int aim){
        if (arr==null||arr.length==0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum-aim)){
                len = Math.max(len,i-map.get(sum-aim));
            }
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int[] arr = {7,3,2,1,1,7,7,7};
        System.out.println(maxLength(arr,7));
    }
}
