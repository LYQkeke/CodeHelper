package com.keke.notebook.c2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/3
 * 爱奇艺
 * 奶牛编号
 * 牛牛养了n只奶牛,牛牛想给每只奶牛编号,这样就可以轻而易举地分辨它们了。 每个奶牛对于数字都有自己的喜好,第i只奶牛想要一个1和x[i]之间的整数(其中包含1和x[i])。
 * 牛牛需要满足所有奶牛的喜好,请帮助牛牛计算牛牛有多少种给奶牛编号的方法,输出符合要求的编号方法总数。
 */
public class Code_034 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n];
        for(int i=0;i<n;i++){
            x[i] = in.nextInt();
        }
        Arrays.sort(x);
        long ans = 1;
        for(int i=0;i<n;i++){
            ans *= (x[i]-i);
            ans %= 1000000007;
        }
        System.out.println(ans);
    }
}
