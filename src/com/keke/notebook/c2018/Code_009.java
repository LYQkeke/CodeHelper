package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 网易05
 * 独立的小易
 * 小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。
 * 一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。
 * 当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。
 * 小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。
 */
public class Code_009 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // 房屋租金
        int x = in.nextInt();
        // 手中现有水果
        int f = in.nextInt();
        // 手中现有钱数
        int d = in.nextInt();
        // 水果的单个价钱
        int p = in.nextInt();

        int days = 0;
        int cost = 0;
        int withFruit = x + p;
        int withoutFruit = x;
        if(d<=f*withoutFruit){
            System.out.println(d/withoutFruit);
            return;
        }
        d -= f*withoutFruit;
        System.out.println(f+d/withFruit);
    }
}
