package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/4
 * 爱奇艺
 * 最后一位
 * 牛牛选择了一个正整数X,然后把它写在黑板上。然后每一天他会擦掉当前数字的最后一位,直到他擦掉所有数位。 在整个过程中,牛牛会把所有在黑板上出现过的数字记录下来,然后求出他们的总和sum.
 * 例如X = 509, 在黑板上出现过的数字依次是509, 50, 5, 他们的和就是564.
 * 牛牛现在给出一个sum,牛牛想让你求出一个正整数X经过上述过程的结果是sum.
 */
public class Code_031 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long sum = in.nextLong();
        System.out.println(getBase(sum));
    }

    public static long getBase(long sum){
        int len = (sum+"").length();
        if(len==1)
            return sum;
        long l = (long) Math.pow(10,len-1);
        long r = (long) Math.pow(10,len+1);
        while(l<=r){
            long mid = l + (r-l)/2;
            long temp = getSum(mid);
            if(temp>sum){
                r = mid - 1;
            }else if(temp<sum){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static long getSum(long num){
        long sum = 0;
        while(num!=0){
            sum += num;
            num /= 10;
        }
        return sum;
    }
}
