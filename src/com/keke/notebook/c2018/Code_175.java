package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/29
 * 去哪儿
 * 日本旅行
 * 楚乔、宇文玥和燕洵在日本旅行，经过了几天的游玩之后，钱包里出现了大量硬币，楚乔决定用钱包里的硬币为宇文玥和燕洵在自动贩卖机买水。
 * 楚乔的钱包里有1元、5元、10元、50元、100元和500元硬币各C1,C5,C10,C50,C100,C500枚。
 * 现在要用这些硬币来到自动贩卖机买价格为A的饮料，假设自动贩卖机所需的硬币金额必须是刚刚好，不能多也不能少，最少需要多少枚硬币？
 * 限制条件
 * 0≤ C1,C5,C10,C50,C100,C500≤1000000000
 * 0≤A≤1000000000
 * 依次输入C1,C5,C10,C50,C100,C500和A，以空格分隔，输出最少所需硬币数，如果该金额不能由所给硬币凑出，则返回NOWAY
 */
public class Code_175 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Money[] money = new Money[6];
        money[0] = new Money(1,in.nextInt());
        money[1] = new Money(5,in.nextInt());
        money[2] = new Money(10,in.nextInt());
        money[3] = new Money(50,in.nextInt());
        money[4] = new Money(100,in.nextInt());
        money[5] = new Money(500,in.nextInt());
        int a = in.nextInt();
        int count = 0;
        for(int i=5;i>=0;i--){
            if(a>=money[i].value&&money[i].num>0){
                int used = a/money[i].value>money[i].num?money[i].num:a/money[i].value;
                count += used;
                a -= used*money[i].value;
                if(a==0){
                    System.out.println(count);
                }
            }
        }
        if(a!=0){
            System.out.println("NOWAY");
        }
    }

    private static class Money{
        int value;
        int num;
        Money(int value, int num){
            this.value = value;
            this.num = num;
        }
    }
}
