package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/9
 * 京东
 * 两个子串
 * 给定一个字符串s, 请计算输出含有连续两个s作为子串的最短字符串。 注意两个s可能有重叠部分。例如,"ababa"含有两个"aba".
 * KMP的变型 -- 求next数组
 */
public class Code_060 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        if(str.length()==1){
            System.out.println(str+str);
            return;
        }
        char[] chs = str.toCharArray();
        int index = getNextEnd(chs);
        System.out.println(str+str.substring(index));
    }

    private static int getNextEnd(char[] chs){
        int[] next = new int[chs.length+1];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while(pos<next.length){
            if(chs[pos-1]==chs[cn]){
                next[pos++] = ++cn;
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[pos++] = 0;
            }
        }
        return next[next.length-1];
    }
}
