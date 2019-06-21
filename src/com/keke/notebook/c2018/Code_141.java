package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/21
 * 滴滴出行
 * 寻找丑数
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
public class Code_141 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<7){
            System.out.println(n);
            return;
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        int ugly2 = 0;
        int ugly3 = 0;
        int ugly5 = 0;
        for(int i=1;i<n;i++){
            ugly[i] = Math.min(ugly[ugly2]*2,Math.min(ugly[ugly3]*3,ugly[ugly5]*5));
            if(ugly[i]==ugly[ugly2]*2){
                ugly2++;
            }
            if(ugly[i]==ugly[ugly3]*3){
                ugly3++;
            }
            if(ugly[i]==ugly[ugly5]*5){
                ugly5++;
            }
        }
        System.out.println(ugly[n-1]);
    }
}
