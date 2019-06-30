package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/30
 * 字节跳动
 * 数列的和
 * 数列的定义如下：数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 */
public class Code_167 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            double sum = n;
            double last = n;
            for(int i=2;i<=m;i++){
                last = Math.sqrt(last);
                sum += last;
            }
            System.out.printf("%.2f\n",sum);
        }
    }
}
