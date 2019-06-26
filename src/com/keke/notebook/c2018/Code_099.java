package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/26
 * 吉比特
 * 求素数
 * 输入M、N，1 < M < N < 1000000，求区间[M,N]内的所有素数的个数。
 * 素数定义：除了1以外，只能被1和自己整除的自然数称为素数
 */
public class Code_099 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        boolean[] notPrime = new boolean[n+1];
        for (int i=m;i<=n;i++){
            if (!notPrime[i]&&isPrime(i)){
                int temp = i*2;
                while (temp<=n){
                    notPrime[temp] = true;
                    temp *= 2;
                }
            }else {
                notPrime[i] = true;
            }
        }
        int count = 0;
        for (int i = m; i <= n; i++) {
            if (!notPrime[i]){
                ++count;
            }
        }
        System.out.println(count);
    }

    private static boolean isPrime(int n){
        if (n<=3)
            return true;
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0)
                return false;
        }
        return true;
    }
}
