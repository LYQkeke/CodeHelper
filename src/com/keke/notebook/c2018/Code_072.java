package com.keke.notebook.c2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/13
 * 网易
 * 数位重排
 * 牛牛有一个正整数x,牛牛需要把数字x中的数位进行重排得到一个新数(不同于x的数),牛牛想知道这个新数是否可能是原x的倍数。
 * 请你来帮他解决这个问题。
 */
public class Code_072 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            isPossible(in.next().toCharArray());
        }
    }

    private static void isPossible(char[] num){
        int n = 10/(num[0]-'0');
        int[] count = new int[10];
        for(int j=0;j<num.length;j++){
            count[num[j]-'0']++;
        }
        for(int i=2;i<=n;i++){
            boolean suc = true;
            int[] temp = Arrays.copyOf(count,count.length);
            int target = i*Integer.valueOf(new String(num));
            while(target!=0){
                int cur = target%10;
                --temp[cur];
                target = target/10;
            }
            for(int j=0;j<temp.length;j++){
                if(temp[j]!=0)
                    suc = false;
            }
            if(suc){
                System.out.println("Possible");
                return;
            }
        }
        System.out.println("Impossible");
    }
}
