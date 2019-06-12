package com.keke.notebook.c2018;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by KEKE on 2019/6/12
 * 京东
 * 括号匹配方案
 * 合法的括号匹配序列被定义为:
 * 1. 空串""是合法的括号序列
 * 2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
 * 3. 如果"X"是一个合法的序列,那么"(X)"也是一个合法的括号序列
 * 4. 每个合法的括号序列都可以由上面的规则生成
 * 例如"", "()", "()()()", "(()())", "(((())))"都是合法的。 东东现在有一个合法的括号序列s,一次移除操作分为两步:
 * 1. 移除序列s中第一个左括号
 * 2. 移除序列s中任意一个右括号.保证操作之后s还是一个合法的括号序列
 * 东东现在想知道使用上述的移除操作有多少种方案可以把序列s变为空
 * 如果两个方案中有一次移除操作移除的是不同的右括号就认为是不同的方案。
 * 例如: s = "()()()()()",输出1, 因为每次都只能选择被移除的左括号所相邻的右括号.
 * s = "(((())))",输出24, 第一次有4种情况, 第二次有3种情况, ... ,依次类推, 4 * 3 * 2 * 1 = 24
 */
public class Code_065 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char[] chs = in.next().toCharArray();
        Stack<Character> stack  = new Stack<>();
        int ans = 1;
        for(int i=0;i<chs.length;i++){
            if(chs[i]=='('){
                stack.push(chs[i]);
            }else{
                ans *= stack.size();
                stack.pop();
            }
        }
        System.out.println(ans);
    }
}
