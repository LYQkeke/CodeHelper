package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/30
 * 字节跳动
 * 水仙花数
 */
public class Code_168 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            int count = 0;
            for(int i=m;i<=n;i++){
                if(isFlower(i)){
                    if(++count!=1){
                        System.out.print(" ");
                    }
                    System.out.print(i);
                }
            }
            if(count==0){
                System.out.print("no");
            }
            System.out.println();
        }
    }

    private static boolean isFlower(int num){
        double sum = 0;
        int temp = num;
        while(temp!=0){
            int r = temp%10;
            if(r!=0){
                sum = sum + Math.pow(r,3);
            }
            temp /=10;
        }
        return sum==num?true:false;
    }
}
