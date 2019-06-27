package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/27
 * 美团点评
 * 字符串距离
 * 给出两个相同长度的由字符 a 和 b 构成的字符串，定义它们的距离为对应位置不同的字符 的数量。
 * 如串”aab”与串”aba”的距离为 2;串”ba”与串”aa”的距离为 1;串”baa”和串”baa”的 距离为 0。
 * 下面给出两个字符串 S 与 T，其中 S 的长度不小于 T 的长度。
 * 我们用|S|代表 S 的 长度，|T|代表 T 的长度，那么在 S 中一共有|S|-|T|+1 个与 T 长度相同的子串，
 * 现在你需要计算 T 串与这些|S|-|T|+1 个子串的距离的和。
 * S和T均由字符a和b组成，1≤ |T| ≤ |S| ≤105。
 */
public class Code_095 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        char[] t = in.next().toCharArray();
        // 用int会超范围
        long[] noa = new long[s.length+1];
        long[] nob = new long[s.length+1];
        for (int i = 1; i < noa.length; i++) {
            noa[i] = s[i-1]=='a'?noa[i-1]+1:noa[i-1];
            nob[i] = i - noa[i];
        }
        long res = 0;
        for (int i = 0; i < t.length; i++) {
            int r = s.length-i;
            int l = r-(s.length-t.length+1);
            if (t[t.length-1-i]=='a'){
                res += nob[r] - nob[l];
            }else {
                res += noa[r] - noa[l];
            }
        }
        System.out.println(res);
    }

    private static void solution1(){
        /**
         * 可以通过70%
         * 剩下的复杂度太高，通不过
         */
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        char[] t = in.next().toCharArray();
        int res = 0;
        for (int i = 0; i <= s.length-t.length ; i++) {
            for (int j = 0; j < t.length; j++) {
                if (s[i+j]!=t[j]){
                    ++res;
                }
            }
        }
        System.out.println(res);
    }
}
