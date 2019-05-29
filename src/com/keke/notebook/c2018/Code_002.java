package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/29
 * 拼多多02
 * 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
 * 一位一位相乘，然后在处理进位
 */
public class Code_002 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(myBigInteger(a,b));
    }

    static String myBigInteger(String a, String b){

        int len1 = a.length();
        int len2 = b.length();
        int[] arrA = new int[len1];
        int[] arrB = new int[len2];
        int[] ans = new int[len1+len2+1];
        for (int i=0;i<len1;i++)
            arrA[i] = a.charAt(len1-1-i)-'0';
        for (int i=0;i<len2;i++)
            arrB[i] = b.charAt(len2-1-i)-'0';
        for (int i=0;i<len2;i++){
            for (int j=0;j<len1;j++){
                ans[i+j] += arrA[j]*arrB[i];
            }
        }
        for (int i=0;i<ans.length-1;i++){
            ans[i+1] += ans[i]/10;
            ans[i] = ans[i]%10;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int i = ans.length-1;
        while (i>0&&ans[i]==0)
            i--;
        while (i>=0){
            sb.append(ans[i]);
            i--;
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }
}
