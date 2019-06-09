package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/9
 */
public class Code_058 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long max1 = Integer.MIN_VALUE;
        long max2 = Integer.MIN_VALUE;
        long max3 = Integer.MIN_VALUE;
        long min1 = Integer.MAX_VALUE;
        long min2 = Integer.MAX_VALUE;
        long num;
        for(int i=0;i<n;i++){
            num = in.nextInt();
            if(num>max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(num>max2){
                max3 = max2;
                max2 = num;
            }else if(num>max3){
                max3 = num;
            }
            if(num<min1){
                min2 = min1;
                min1 = num;
            }else if(num<min2){
                min2 = num;
            }
        }
        System.out.println(Math.max(max1*max2*max3,min1*min2*max1));
    }
}
