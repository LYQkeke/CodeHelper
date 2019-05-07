package com.keke.notebook.zuo.basic.class_08;

/**
 * Created by KEKE on 2019/5/7
 *
 * 数组arr表示现有的钱数，问使用其中的钱数是否可以凑够aim员
 * 钱数均为正，并且aim也为正
 */
public class Code_08_Money_Problem {

    public static boolean money1(int[] arr, int aim){
        return process1(arr,0,0,aim);
    }

    /**
     * 暴力递归
     * @param arr
     * @param i
     * @param sum
     * @param aim
     * @return
     */
    private static boolean process1(int[] arr, int i, int sum, int aim){
        if (sum==aim)
            return true;
        if (i==arr.length)
            return false;
        return process1(arr,i+1, sum, aim)||process1(arr, i+1, sum+arr[i], aim);
    }

    /**
     * 由暴力递归--》动态规划
     * @param arr
     * @param aim
     * @return
     */
    public static boolean money2(int[] arr, int aim){
        // dp数组的范围是由暴力递归的可达范围决定的
        // 与具体问题无关
        boolean[][] dp = new boolean[arr.length+1][aim+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        for (int i=arr.length-1;i>=0;i--){
            for (int j=aim-1;j>=0;j--){
                if (j+arr[i]<=aim){
                    dp[i][j] = dp[i+1][j]||dp[i+1][j+arr[i]];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,5,8};
        System.out.println(money1(arr,9));
        System.out.println(money2(arr,9));
    }
}
