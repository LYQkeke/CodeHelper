package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/9
 * 拼多多
 * 数三角形
 * 给出平面上的n个点，现在需要你求出，在这n个点里选3个点能构成一个三角形的方案有几种。
 * 直接暴力
 */
public class Code_057 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0;i<n;i++){
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        int count = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(!inLine(x[i],y[i],x[j],y[j],x[k],y[k]))
                        count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean inLine(int x1, int y1, int x2, int y2, int x3, int y3){
        if(x1==x2&&x2==x3)
            return true;
        if(y1==y2&&y2==y3)
            return true;
        if((y2-y3)*(x1-x2)==(y1-y2)*(x2-x3))
            return true;
        else
            return false;
    }
}
