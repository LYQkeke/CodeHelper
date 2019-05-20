package com.keke.notebook.jzoffer;

/**
 * Created by KEKE on 2019/5/20
 * 斐波那契数列
 */
public class Code_07 {
    public int Fibonacci(int n) {
        if(n==0)
            return 0;
        if(n==1||n==2)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
