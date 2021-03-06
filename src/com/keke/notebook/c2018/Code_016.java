package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 爱奇艺04
 * 删除重复字符
 * 牛牛有一个由小写字母组成的字符串s,在s中可能有一些字母重复出现。比如在"banana"中,字母'a'和字母'n'分别出现了三次和两次。
 * 但是牛牛不喜欢重复。对于同一个字母,他只想保留第一次出现并删除掉后面出现的字母。请帮助牛牛完成对s的操作。
 */
public class Code_016 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String input = in.next();
            boolean[] map = new boolean[26];
            String ans = "";
            for(int i=0;i<input.length();i++){
                int index = input.charAt(i)-'a';
                if(!map[index]){
                    map[index] = true;
                    ans += input.charAt(i);
                }
            }
            System.out.println(ans);
        }
    }
}
