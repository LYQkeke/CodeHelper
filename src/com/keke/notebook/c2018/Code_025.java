package com.keke.notebook.c2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 爱奇艺
 * 牛牛手中有三根木棍,长度分别是a,b,c。
 * 牛牛可以把任一一根木棍长度削短,牛牛的目标是让这三根木棍构成一个三角形,并且牛牛还希望这个三角形的周长越大越好。
 */
public class Code_025 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] edge = new int[3];
        for(int i=0;i<3;i++){
            edge[i] = in.nextInt();
        }
        Arrays.sort(edge);
        if(edge[0]+edge[1]>edge[2]){
            System.out.println(edge[0]+edge[1]+edge[2]);
        }else{
            System.out.println((edge[0]+edge[1])*2-1);
        }
    }
}
