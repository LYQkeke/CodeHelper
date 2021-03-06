package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 爱奇艺03
 * 判断题
 * 牛牛参加了一场考试,考试包括n道判断题,每做对一道题获得1分,牛牛考试前完全没有准备,
 * 所以考试只能看缘分了,牛牛在考试中一共猜测了t道题目的答案是"正确",其他的牛牛猜为"错误"。
 * 考试结束后牛牛知道实际上n道题中有a个题目的答案应该是"正确",但是牛牛不知道具体是哪些题目,
 * 牛牛希望你能帮助他计算可能获得的最高的考试分数是多少。
 */
public class Code_015 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int t = in.nextInt();
            int a = in.nextInt();
            System.out.println(n-Math.abs(t-a));
        }
    }
}
