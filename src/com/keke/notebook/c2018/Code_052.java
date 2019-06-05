package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/5
 * 搜狐
 * Kolakoski
 * Kolakoski 序列是个自生成的无限序列。
 * 例如，当给定的整数组为 [1, 2] 时，Kolakoski 序列是这样的：
 * [1,2,2,1,1,2,1,2,2,1,2,2,1,1,2,1,1,2,2,1,2,1,1,2,1,2,2,1,1,…]
 * 如果我们将相邻的相同的数字分成一组，那么将会得到：
 * [[1],[2,2],[1,1],[2],[1],[2,2],[1],[2,2],[1,1],[2],[1,1],[2,2],[1],[2],[1,1],[2],[1],[2,2],[1,1],…]
 * 可以看出，每组数字交替由 1, 2 组成。
 * 接下来对每个分组求他的长度，得到：
 * [1,2,2,1,1,2,1,2,2,1,2,2,1,1,2,1,1,2,2,1,2,1,1,2,1,2,2,1,1,…]
 * 可以看出，经过如上的变换后，数列保持不变。
 * 对于其他给定的整数组，同样可以用类似的方法构造 Kolakoski 序列，例如给定整数组 [2, 3] 时：
 * [2,2,3,3,2,2,2,3,3,3,2,2,3,3,2,2,3,3,3,2,2,2,3,3,3,2,2,3,3,…]
 * 给定整数组 [2, 1, 3, 1] 时，构造得到如下：
 * [2,2,1,1,3,1,2,2,2,1,3,3,1,1,2,2,1,3,3,3,1,1,1,2,1,3,3,1,1,…]
 */
public class Code_052 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[m];
        int[] chs = new int[n];
        for(int i=0;i<m;i++){
            a[i] = in.nextInt();
        }
        int ai = 0;
        int ni = 0;
        int nj = 0;
        while(ni<n){
            int i = 0;
            if(ni==nj){
                i = a[ai%a.length];
            }else{
                i = chs[nj];
            }
            while(ni<n&&i-->0){
                chs[ni++] = a[ai];
            }
            ai = (ai+1)%a.length;
            nj++;
        }
        for(int i=0;i<chs.length;i++){
            System.out.println(chs[i]);
        }
    }
}
