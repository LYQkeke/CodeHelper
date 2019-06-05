package com.keke.notebook.c2018;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/5
 * 搜狐
 * Unix路径简化
 * 简化 Unix 风格的路径，需要考虑的包括 "/../", "//", "/./" 等情况
 */
public class Code_053 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String path = in.next();
        String[] paths = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for(String temp:paths){
            if(temp.equals("..")){
                deque.pollLast();
            }else if(temp.equals("")||temp.equals(".")){

            }else{
                deque.addLast(temp);
            }
        }
        if(deque.size()==0)
            System.out.print("/");
        while(deque.size()>0){
            System.out.print("/"+deque.pollFirst());
        }
        System.out.println();
    }
}
