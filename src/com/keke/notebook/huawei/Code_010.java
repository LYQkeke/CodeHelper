package com.keke.notebook.huawei;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/22
 * 字符个数统计
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
 */
public class Code_010 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int[] map = new int[128];
        int count = 0;
        for (int i=0;i<str.length();i++){
            char cur = str.charAt(i);
            if (cur>=0&&cur<=127&&map[cur]==0){
                count++;
                map[cur]++;
            }
        }
        System.out.println(count);
    }
}
