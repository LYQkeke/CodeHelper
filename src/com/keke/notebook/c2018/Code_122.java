package com.keke.notebook.c2018;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by KEKE on 2019/7/3
 * 百度
 * 完成括号匹配
 * 合法的括号匹配序列被定义为:
 * 1. 空串""是合法的括号序列
 * 2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
 * 3. 如果"X"是一个合法的序列,那么"[X]"也是一个合法的括号序列
 * 4. 每个合法的括号序列都可以由上面的规则生成
 * 例如"", "[]", "[][][]", "[[][]]", "[[[[]]]]"都是合法的。
 * 牛牛现在给出一个括号序列s,牛牛允许你执行的操作是:在s的开始和结尾处添加一定数量的左括号('[')或者右括号(']')使其变为一个合法的括号匹配序列。
 * 牛牛希望你能求出添加最少的括号之后的合法的括号匹配序列是什么。
 */
public class Code_122 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char[] chs = in.next().toCharArray();
        int rn = 0;
        int ln = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<chs.length;i++){
            if(chs[i]=='['){
                stack.push(chs[i]);
            }else{
                if(stack.isEmpty()){
                    ++rn;
                }else{
                    stack.pop();
                }
            }
        }
        ln = stack.size();
        StringBuilder sb = new StringBuilder();
        while(rn--!=0){
            sb.append("[");
        }
        sb.append(new String(chs));
        while(ln--!=0){
            sb.append("]");
        }
        System.out.println(sb.toString());
    }
}
