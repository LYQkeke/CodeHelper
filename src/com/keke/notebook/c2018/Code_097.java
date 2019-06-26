package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/26
 * 美团点评
 * 魔法表
 * 时辰送给了她的女儿凛一块魔法表，但是魔法表的表针总是指向奇怪的地方，所以凛决定修 理一下这块表。
 * 当前表的指针指向了一个方向𝑛1(在 0 度到 359 度之间，正北方向是 0 度， 正东方向是 90 度)，她需要将表针调节到方向𝑛2。
 * 她可以选择顺时针旋转表针，也可以逆 时针旋转表针，若顺时针旋转的话，角度会增大，逆时针旋转则角度会减小。
 * 当顺时针旋转 到 359 度后，若再旋转一度，则会回到 0 度。凛想要让表针旋转的角度尽量小，也就是以 最短路径旋转到正确的方向，请你告诉她应该如何旋转。
 * 当有多种旋转方式能够旋到正确的方向，且旋转过的角度相同时，凛会选择顺时针旋转。
 */
public class Code_097 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int r1 = 0;
        int r2 = 0;
        if(n1==n2){
            System.out.println(0);
            return;
        }else if(n1<n2){
            r1 = n2 - n1;
            r2 = 360 - n2 + n1;
        }else {
            r1 = 360 - n1 + n2;
            r2 = n1 - n2;
        }
        if(r1<=r2){
            System.out.println(r1);
        }else{
            System.out.println("-"+r2);
        }
    }
}
