package com.keke.notebook.huawei;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/13
 * 计算字符个数
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 */
public class Code_002 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next().toLowerCase();
        char c = in.next().toLowerCase().charAt(0);
        int count = 0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==c)
                count++;
        }
        System.out.println(count);
    }
}
