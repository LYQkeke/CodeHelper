package com.keke.notebook.c2018;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by KEKE on 2019/6/3
 * 爱奇艺
 * 括号匹配深度
 * 一个合法的括号匹配序列有以下定义:
 * 1、空串""是一个合法的括号匹配序列
 * 2、如果"X"和"Y"都是合法的括号匹配序列,"XY"也是一个合法的括号匹配序列
 * 3、如果"X"是一个合法的括号匹配序列,那么"(X)"也是一个合法的括号匹配序列
 * 4、每个合法的括号序列都可以由以上规则生成。
 * 例如: "","()","()()","((()))"都是合法的括号序列
 * 对于一个合法的括号序列我们又有以下定义它的深度:
 * 1、空串""的深度是0
 * 2、如果字符串"X"的深度是x,字符串"Y"的深度是y,那么字符串"XY"的深度为max(x,y) 3、如果"X"的深度是x,那么字符串"(X)"的深度是x+1
 * 例如: "()()()"的深度是1,"((()))"的深度是3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。
 */
public class Code_033 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        Stack<Character> stack = new Stack<>();
        int deep = 0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='('){
                stack.push(input.charAt(i));
            }else{
                stack.pop();
            }
            deep = Math.max(deep,stack.size());
        }
        System.out.println(deep);
    }
}
