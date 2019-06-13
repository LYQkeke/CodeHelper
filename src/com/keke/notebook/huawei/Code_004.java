package com.keke.notebook.huawei;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/13
 * 字符串分割
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class Code_004 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.next();
            int start = 0;
            while(start<s.length()){
                if(start+8<s.length()){
                    eightPrint(s.substring(start,start+8));
                }else{
                    eightPrint(s.substring(start,s.length()));
                }
                start += 8;
            }
        }
    }

    private static void eightPrint(String s){
        System.out.print(s);
        for(int i=s.length();i<8;i++){
            System.out.print('0');
        }
        System.out.println();
    }
}
