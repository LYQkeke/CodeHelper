package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/27
 * 美团点评
 * 连线游戏
 * 某一天，Alice 比较无聊，于是她为自己发明了一个游戏玩。首先她在纸上画了一个圆，然 后从这个圆的圆弧上均匀地取出 n 个点，这 n 个点将圆 n 等分。
 * 接下来，Alice 每次从这 n 个点中选取两个点，在这两个点之间画一条线段，但是要求这条线段不能与已有的线段相交 (允许在端点处相交)。
 * 为了能打发更多的时间，Alice 希望能画尽量多的线段，请你告诉她 最多她能画出几条线段?
 */
public class Code_096 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(n+n-3);
    }
}
