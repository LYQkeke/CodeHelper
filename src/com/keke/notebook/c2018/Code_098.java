package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/26
 * 贪心的小博
 *
 */
public class Code_098 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 需要用 long 不然可能超范围
        long res = 0;
        while(in.hasNext()){
            res += in.nextInt();
        }
        res -= n - 1;
        System.out.println(res);
    }
}
