package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 爱奇艺
 * 空中旅行
 * 牛牛有羊羊有了属于他们自己的飞机。于是他们进行几次连续的飞行。f[i]表示第i次飞行所需的燃油的升数。飞行只能按照f数组所描述的顺序进行。
 * 起初飞机里有s升燃油,为了正常飞行,每次飞行前飞机内燃油量应大于等于此处飞行所需要的燃油量。
 * 请帮助他们计算在不进行加油的情况下他们能进行的飞行次数
 */
public class Code_017 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int s = in.nextInt();
            int[] f = new int[n];
            int count = 0;
            for(int i=0;i<n;i++){
                f[i] = in.nextInt();
            }
            for(int i=0;i<n;i++){
                s -= f[i];
                if(s>=0){
                    count++;
                }else{
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
