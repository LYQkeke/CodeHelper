package com.keke.notebook.c2018;

import java.util.*;

/**
 * Created by KEKE on 2019/6/4
 * 唯品会
 * 字符串组合 -- 枚举 去重
 * 输入一个字符串，输出该字符串中#相邻#字符的所有组合。
 * 举个例子，如果输入abc，它的组合有a、b、c、ab、bc、abc。（注意：输出的组合需要去重）
 */
public class Code_048 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        Set<String> set = new TreeSet<>(new Comparator<String>(){
            public int compare(String o1,String o2){
                return o1.length()==o2.length()?o1.compareTo(o2):o1.length()-o2.length();
            }
        });
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                set.add(s.substring(i,j));
            }
        }
        for(String str:set){
            System.out.print(str+" ");
        }
        System.out.println();
    }
}
