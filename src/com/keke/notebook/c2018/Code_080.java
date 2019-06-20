package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/20
 * 美团点评
 * 抽牌
 */
public class Code_080 {

    private static double p;
    private static double q;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        p = in.nextInt()/100.0;
        q = in.nextInt()/100.0;
        int[] poker = new int[n];
        for (int i=0;i<n;i++){
            poker[i] = in.nextInt();
        }
        System.out.printf("%.3f\n",processDP(poker));
    }

    /**
     * 递归的方法
     * 递归过40%
     * @param poker
     * @param begin
     * @param end
     * @param ming
     * @return
     */
    private static double process(int[] poker, int begin, int end, boolean ming){
        if (begin==end){
            return ming?poker[begin]/1.0:0;
        }
        double tempVal1,tempVal2;
        // 判断是否轮到小明抽牌
        if (ming){
            tempVal1 = p*(poker[begin]+process(poker,begin+1,end,false));
            tempVal2 = (1-p)*(poker[end]+process(poker,begin,end-1,false));
        }else {
            tempVal1 = q*process(poker,begin+1,end,true);
            tempVal2 = (1-q)*process(poker,begin,end-1,true);
        }
        return tempVal1+tempVal2;
    }

    /**
     * 递归改动态规划
     * @param poker
     * @return
     */
    private static double processDP(int[] poker){
        double[][] dpMing = new double[poker.length][poker.length];
        double[][] dpFang = new double[poker.length][poker.length];
        for (int i=0;i<poker.length;i++){
            dpMing[i][i] = poker[i];
            dpFang[i][i] = 0.0;
        }
        for (int i=poker.length-2;i>=0;i--){
            for (int j=i+1;j<poker.length;j++){
                dpFang[i][j] = q*dpMing[i+1][j] + (1-q)*dpMing[i][j-1];
                dpMing[i][j] = p*(poker[i]+dpFang[i+1][j]) + (1-p)*(poker[j]+dpFang[i][j-1]);
            }
        }
        return dpMing[0][poker.length-1];
    }
}
