package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/7/2
 * 招商银行信用卡
 * 小招喵跑步
 * 小招喵喜欢在数轴上跑来跑去，假设它现在站在点n处，它只会3种走法，分别是：
 * 1.数轴上向前走一步，即n=n+1
 * 2.数轴上向后走一步,即n=n-1
 * 3.数轴上使劲跳跃到当前点的两倍，即n=2*n
 * 现在小招喵在原点，即n=0，它想去点x处，快帮小招喵算算最快的走法需要多少步？
 */
public class Code_128 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // 还可以输入负数....
        int n = Math.abs(in.nextInt());
        if(n<=3){
            System.out.println(n);
            return;
        }
        int[] axis = new int[n+2];
        axis[1] = 1;
        axis[2] = 2;
        axis[3] = 3;
        for(int i=4;i<axis.length;i+=2){
            int mid = i/2;
            if(axis[mid]==0){
                axis[mid] = Math.min(axis[mid-1]+1,axis[mid+1]+1);
                axis[i] = axis[mid] + 1;
            }else{
                axis[i] = axis[mid] + 1;
            }
        }
        if((n&1)==0){
            System.out.println(axis[n]);
        }else{
            System.out.println(Math.min(axis[n-1]+1,axis[n+1]+1));
        }
    }
}
