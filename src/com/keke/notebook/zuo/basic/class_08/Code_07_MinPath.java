package com.keke.notebook.zuo.basic.class_08;

/**
 * Created by KEKE on 2019/5/7
 * 最小路径问题
 */
public class Code_07_MinPath {

    public static int minPath1(int[][] m){
        return process1(m,m.length-1,m[0].length-1);
    }

    /**
     * 暴力递归
     * @param m
     * @param i
     * @param j
     * @return
     */
    private static int process1(int[][] m, int i, int j){
        int res = m[i][j];
        if (i==0&&j==0)
            return res;
        if (i==0&&j!=0)
            return process1(m,i,j-1) + res;
        if (i!=0&&j==0)
            return process1(m,i-1,j) + res;
        return Math.min(process1(m,i-1,j),process1(m,i,j-1)) + res;
    }

    /**
     * 暴力递归改动态规划
     * @param m
     * @return
     */
    public static int minPath2(int[][] m){
        int[][] dp = new int[m.length][m[0].length];
        dp[0][0] = m[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i-1][0] + m[i][0];
        }
        for (int i = 1; i < m[0].length; i++) {
            dp[0][i] = dp[0][i-1] + m[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + m[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }

}
