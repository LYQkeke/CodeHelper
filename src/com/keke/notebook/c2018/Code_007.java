package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 网易03
 * 交错01串
 * 如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
 * 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 */
public class Code_007 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        if(s.length()==1){
            System.out.println(1);
            return;
        }
        int max = 1;
        int tempMax = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                if(++tempMax>max){
                    max = tempMax;
                }
            }else{
                tempMax = 1;
            }
        }
        System.out.println(max);
    }

}
