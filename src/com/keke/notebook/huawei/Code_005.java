package com.keke.notebook.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by KEKE on 2019/6/13
 * 进制转换
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 */
public class Code_005 {

    public static Map<Character,Integer> map = new HashMap<>();
    static{
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        while(in.hasNext()){
            String s = in.next();
            for(int i=2;i<s.length();i++){
                stack.push(s.charAt(i));
            }
            long base = 1;
            long sum = 0;
            while(!stack.isEmpty()){
                sum += map.get(stack.pop())*base;
                base *= 16;
            }
            System.out.println(sum);
        }
    }
}
