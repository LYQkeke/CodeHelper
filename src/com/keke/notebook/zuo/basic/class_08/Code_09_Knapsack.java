package com.keke.notebook.zuo.basic.class_08;

/**
 * Created by KEKE on 2019/5/7
 *
 * 普通背包问题
 */
public class Code_09_Knapsack {

    public static int maxValue1(int[] weights, int[] values, int bag){
        return process2(weights,values,0,0,bag);
    }

    /**
     * 左神给的暴力递归是错的
     * @param weights
     * @param values
     * @param i
     * @param curWeight
     * @param bag
     * @return
     */
    private static int process1(int[] weights, int[] values, int i, int curWeight, int bag){
        if (curWeight>bag)
            return 0;
        if (i==weights.length)
            return 0;
        // 这一步返回的，始终加上values的要大
        return Math.max(
                process1(weights,values,i+1,curWeight,bag),
                values[i] + process1(weights,values,i+1,curWeight+weights[i],bag)
        );
    }

    /**
     * 正确的暴力递归方法
     * @param weights
     * @param values
     * @param i
     * @param curWeight
     * @param bag
     * @return
     */
    private static int process2(int[] weights, int[] values, int i, int curWeight, int bag){
        if (curWeight>bag)
            return 0;
        if (i==weights.length)
            return 0;
        if (curWeight+weights[i]<=bag)
            return Math.max(
                process2(weights,values,i+1,curWeight,bag),
                values[i] + process2(weights,values,i+1,curWeight+weights[i],bag)
            );
        else
            return process2(weights,values,i+1,curWeight,bag);
    }

    /**
     * 暴力递归改动态规划
     * @param weights
     * @param values
     * @param bag
     * @return
     */
    public static int maxValue2(int[] weights, int[] values, int bag){
        int[][] dp = new int[weights.length+1][bag+1];
        for (int i=weights.length-1;i>=0;i--){
            for (int j=bag;j>=0;j--){
                dp[i][j] = dp[i+1][j];
                if (j+weights[i]<=bag){
                    dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+weights[i]]+values[i]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(maxValue1(c,p,bag));
        System.out.println(maxValue2(c,p,bag));
    }
}
