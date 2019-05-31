package com.keke.notebook.c2018;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by KEKE on 2019/5/31
 * 爱奇艺
 * 缺失的括号
 * 一个完整的括号字符串定义规则如下:
 * 1、空字符串是完整的。
 * 2、如果s是完整的字符串，那么(s)也是完整的。
 * 3、如果s和t是完整的字符串，将它们连接起来形成的st也是完整的。
 * 例如，"(()())", ""和"(())()"是完整的括号字符串，"())(", "()(" 和 ")"是不完整的括号字符串。
 * 牛牛有一个括号字符串s,现在需要在其中任意位置尽量少地添加括号,将其转化为一个完整的括号字符串。请问牛牛至少需要添加多少个括号。
 */
public class Code_030 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char[] chs = in.next().toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0;i<chs.length;i++){
            if(chs[i]=='('){
                stack.push(chs[i]);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    count++;
                }
            }
        }
        count += stack.size();
        System.out.println(count);
    }
}
