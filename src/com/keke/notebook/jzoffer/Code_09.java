package com.keke.notebook.jzoffer;

/**
 * Created by KEKE on 2019/5/20
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Code_09 {
    public int JumpFloorII(int target) {
        if(target==1)
            return 1;
        int ans = 1;
        /**
         * 实际上是求2^target-1
         * f n = 2 * f n-1
         */
        while(--target>0){
            ans = ans << 1;
        }
        return ans;
    }
}
