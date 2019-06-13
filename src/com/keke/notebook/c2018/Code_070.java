package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/13
 * 网易
 * 缩写
 * 在英文中,我们会把一些长的名字或者短语进行缩写。
 * 例如"looks good to me"缩写为"lgtm",短语中的每个单词的首字母组成缩写。
 * 现在给出一个字符串s,字符串s中包括一个或者多个单词,单词之间以空格分割,请输出这个字符串的缩写。
 */
public class Code_070 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split(" ");
        for(String s:words){
            System.out.print(s.charAt(0));
        }
        System.out.println();
    }
}
