package com.keke.notebook.c2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/7/3
 * 招商银行信用卡
 * 寻找合法字符串
 * 给出一个正整数n，请给出所有的包含n个'('和n个')'的字符串，使得'('和')'可以完全匹配。
 * 例如：
 * '(())()'，'()()()' 都是合法的；
 * '())()('是不合法的。
 * 请按照__字典序__给出所有合法的字符串。
 */
public class Code_136 {

    private static List<String> ansList =new ArrayList<>();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = n;
        int r = n;
        solution(0,0, l, r, new StringBuilder());
        Collections.sort(ansList);
        StringBuilder sb = new StringBuilder();
        for (String s: ansList){
            sb.append(","+s);
        }
        System.out.println(sb.substring(1));
    }

    private static void solution(int i, int j, int l, int r, StringBuilder sb){
        if ((i+j)==(l+r)){
            ansList.add(sb.toString());
            return;
        }
        if (i!=l){
            sb.append("(");
            solution(i+1,j,l,r,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if (i!=j){
            sb.append(")");
            solution(i,j+1,l,r,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
