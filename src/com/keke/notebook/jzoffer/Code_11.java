package com.keke.notebook.jzoffer;

/**
 * Created by KEKE on 2019/5/20\
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Code_11 {
    public int NumberOf1(int n) {
        int count = 0;
        // 进行无符号右移操作，连符号位一块移动，统一了整数和负数操作
        for(;n!=0;n>>>=1)
            if((n&1)!=0)
                count++;
        return count;
    }
}
