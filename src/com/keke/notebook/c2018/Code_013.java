package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 爱奇艺01
 * 循环数比较
 * 对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
 * 牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
 */
public class Code_013 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String x1 = in.nextInt()+"";
            int k1 = in.nextInt();
            String x2 = in.nextInt()+"";
            int k2 = in.nextInt();
            //char[] ch1 = x1.toCharArray();
            //char[] ch2 = x2.toCharArray();
            int len1 = x1.length()*k1;
            int len2 = x2.length()*k2;
            if(len1>len2){
                System.out.println("Greater");
                return;
            }
            if(len1<len2){
                System.out.println("Less");
                return;
            }
            for(int i=len1-1;i>=0;i--){
                int index1 = x1.length()-i%x1.length()-1;
                int index2 = x2.length()-i%x2.length()-1;
                if(x1.charAt(index1)>x2.charAt(index2)){
                    System.out.println("Greater");
                    return;
                }
                if(x1.charAt(index1)<x2.charAt(index2)){
                    System.out.println("Less");
                    return;
                }
            }
            System.out.println("Equal");
        }
    }
}
