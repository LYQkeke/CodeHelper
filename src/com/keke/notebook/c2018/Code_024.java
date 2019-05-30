package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 爱奇艺
 * 红和绿
 * 牛牛有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。牛牛现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将会被覆盖。牛牛的目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。牛牛想知道他最少需要涂染几个正方形。
 * 如样例所示: s = RGRGR
 * 我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。
 */
public class Code_024 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int[] r = new int[input.length()+1];
        int[] g = new int[input.length()+1];
        for(int i=1;i<g.length;i++){
            if(input.charAt(i-1)=='G'){
                g[i] = g[i-1]+1;
            }else{
                g[i] = g[i-1];
            }
        }
        for(int i=r.length-2;i>=0;i--){
            if(input.charAt(i)=='R'){
                r[i] = r[i+1]+1;
            }else{
                r[i] = r[i+1];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<r.length;i++){
            min = Math.min(min,r[i]+g[i]);
        }
        System.out.println(min);
    }
}
