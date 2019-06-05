package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/5
 * 美丽联合
 * 计算一年中的第几天
 * 今年的第几天？
 * 输入年、月、日，计算该天是本年的第几天。
 */
public class Code_050 {
    static int[] dayOfMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int y = in.nextInt();
            int m = in.nextInt();
            int d = in.nextInt();
            if((y%400==0)||(y%100!=0&&y%4==0))
                dayOfMonth[2] = 29;
            else
                dayOfMonth[2] = 28;
            int sum = 0;
            for(int i=0;i<m;i++){
                sum += dayOfMonth[i];
            }
            System.out.println(sum+d);
        }
    }
}
