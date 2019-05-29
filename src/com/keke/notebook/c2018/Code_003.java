package com.keke.notebook.c2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/29
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，
 * 对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。
 * 老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。
 * 可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 */
public class Code_003 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for(int i=0;i<h.length;i++){
            h[i] = in.nextInt();
        }
        n = in.nextInt();
        int[] w = new int[n];
        for(int i=0;i<w.length;i++){
            w[i] = in.nextInt();
        }
        Arrays.sort(h);
        Arrays.sort(w);
        int i=0,j=0,ans=0;
        while(i<h.length&&j<w.length){
            if(w[j]>=h[i]){
                i++;
                j++;
                ans++;
            }else{
                j++;
            }
        }
        System.out.println(ans);
    }
}
