package com.keke.notebook.c2018;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by KEKE on 2019/6/11
 * 爱奇艺
 * DNA序列
 * 牛牛又从生物科研工作者那里获得一个任务,这次牛牛需要帮助科研工作者从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度。
 * 例如:s = AGGTCTA
 * 序列中包含了所有长度为1的('A','C','G','T')片段,但是长度为2的没有全部包含,例如序列中不包含"AA",所以输出2。
 */
public class Code_014 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        for(int i=1;i<=input.length();i++){
            Set<String> set = new HashSet<>();
            for(int j=input.length();j>=i;j--){
                set.add(input.substring(j-i,j));
            }
            if(set.size()<Math.pow(4,i)){
                System.out.println(i);
                return;
            }
        }
    }
}
