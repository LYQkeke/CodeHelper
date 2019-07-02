package com.keke.notebook.c2018;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by KEKE on 2019/7/2
 * 百度
 * 最大子序列
 * 对于字符串x和y, 如果擦除x中的某些字母(有可能全擦掉或者都不擦)能够得到y,我们就称y是x的子序列。
 * 例如."ncd"是"nowcoder"的子序列,而"xt"不是。
 * 现在对于给定的一个字符串s,请计算出字典序最大的s的子序列。
 */
public class Code_126 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char[] chs = in.next().toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chs[chs.length-1]);
        for(int i=chs.length-2;i>=0;i--){
            if(chs[i]>=stack.peek()){
                stack.push(chs[i]);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
