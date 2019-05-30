package com.keke.notebook.c2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/5/30
 * 爱奇艺
 * 数字游戏
 * 牛牛举办了一场数字游戏,有n个玩家参加这个游戏,游戏开始每个玩家选定一个数,
 * 然后将这个数写在纸上(十进制数,无前缀零),然后接下来对于每一个数字将其数位按照非递减顺序排列,
 * 得到新的数,新数的前缀零将被忽略。得到最大数字的玩家赢得这个游戏。
 */
public class Code_023 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //while(in.hasNext()){
        int n = in.nextInt();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            char[] chs = in.next().toCharArray();
            Arrays.sort(chs);
            int cur = Integer.parseInt(new String(chs));
            max = Math.max(max,cur);
        }
        System.out.println(max);
        //}
    }
}
