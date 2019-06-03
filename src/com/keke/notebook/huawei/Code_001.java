package com.keke.notebook.huawei;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/3
 * 字符串最后一个单词的长度
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 */
public class Code_001 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int count = 0;
        for(int i=input.length()-1;i>=0;i--){
            if(input.charAt(i)!=' ')
                count++;
            else
                break;
        }
        System.out.println(count);
    }
}
