package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/12
 * 网易
 * 小易喜欢的数列
 * 小易非常喜欢拥有以下性质的数列:
 * 1、数列的长度为n
 * 2、数列中的每个数都在1到k之间(包括1和k)
 * 3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可)
 * 例如,当n = 4, k = 7
 * 那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
 * 但是小易不喜欢{4,4,4,2}这个数列。小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。
 */
public class Code_012 {

    private static int mod = 1000000007;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int sum = 0;
        int unValid = 0;
        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=k;i++){
            dp[1][i] = 1;
        }
        for(int i=2;i<=n;i++){
            sum = 0;
            for(int j=1;j<=k;j++){
                sum = (sum + dp[i-1][j])%mod;
            }
            for(int j=1;j<=k;j++){
                unValid = 0;
                int p = 2;
                while(p*j<=k){// 保证只计算范围内的数据，如果简单遍历的话会超时
                    unValid = (unValid + dp[i-1][p*j])%mod;
                    p++;
                }
                dp[i][j] = (sum-unValid)%mod;
            }
        }
        sum = 0;
        for(int i=1;i<=k;i++){
            sum = (sum + dp[n][i])%mod;
        }
        System.out.println(sum);
    }
}
