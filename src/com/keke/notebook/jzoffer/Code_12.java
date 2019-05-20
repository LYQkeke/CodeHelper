package com.keke.notebook.jzoffer;

/**
 * Created by KEKE on 2019/5/20
 * 数值的整数次方
 */
public class Code_12 {
    public double Power(double base, int exponent) {
        if(exponent==0)
            return 1;
        // 注意处理负数次幂
        boolean neg = false;
        if(exponent<0){
            neg = true;
            exponent = -exponent;
        }
        double ans = 1;
        double temp = 1;
        while(exponent!=0){
            temp = temp*base;
            if((exponent&1)!=0)
                ans = ans*temp;
            exponent>>=1;
        }
        if(neg)
            return 1/ans;
        else
            return ans;
    }
}
