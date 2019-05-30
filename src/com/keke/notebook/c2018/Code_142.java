package com.keke.notebook.c2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 滴滴出行
 * xor
 * 给出n个数字 a_1,...,a_n，问最多有多少不重叠的非空区间，使得每个区间内数字的xor都等于0。
 */
public class Code_142 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        System.out.println(mostEOR(arr));
    }

    private static int mostEOR(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int[] dp = new int[arr.length];
        int xor = 0;
        //int ans = 0;
        for(int i=0;i<arr.length;i++){
            xor ^= arr[i];
            if(map.containsKey(xor)){
                int pre = map.get(xor);
                dp[i] = (pre==-1)?1:(dp[pre]+1);
            }
            if(i>0){
                dp[i] = Math.max(dp[i],dp[i-1]);
            }
            map.put(xor,i);
            //ans = Math.max(ans,dp[i]);
        }
        return dp[dp.length-1];
    }
}
