package com.keke.notebook.c2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 爱奇艺
 * 拼凑正方形
 * 牛牛有4根木棍,长度分别为a,b,c,d。
 * 羊羊家提供改变木棍长度的服务,如果牛牛支付一个硬币就可以让一根木棍的长度加一或者减一。
 * 牛牛需要用这四根木棍拼凑一个正方形出来,牛牛最少需要支付多少硬币才能让这四根木棍拼凑出正方形。
 */
public class Code_021 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int[] edge = new int[4];
            for(int i=0;i<4;i++){
                edge[i] = in.nextInt();
            }
            Arrays.sort(edge);
            System.out.println(edge[3]+edge[2]-edge[1]-edge[0]);
        }
    }
}
