package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/5
 * 搜狐
 * 包裹运输
 * 工厂生产的产品包装在相同高度h，尺寸为1 * 1,2 * 2，3 * 3，4 * 4，5 * 5，6 * 6的方形包装中。
 * 这些产品始终以与产品高度相同的尺寸为6 * 6的包裹交付给客户。因为邮费很贵，所以工厂要想方设法的减小每个订单运送时的包裹数量。
 * 他们很需要有一个好的程序帮他们解决这个问题从而节省费用。现在这个程序由你来设计。
 */
public class Code_051 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int end = 0;
            int[] nums = new int[6];
            for(int i=0;i<6;i++){
                nums[i] = in.nextInt();
                end = end|nums[i];
            }
            if(end==0)
                return;
            int sum = 0;
            int[] x = new int[3];
            for(int i=5;i>=0;i--){
                if(nums[i]!=0){
                    if(i==5){
                        sum += nums[i];
                    }
                    if(i==4){
                        sum += nums[i];
                        x[0] += nums[i]*11;
                    }
                    if(i==3){
                        sum += nums[i];
                        x[1] += nums[i]*5;
                        x[0] += nums[i]*20;
                    }
                    if(i==2){
                        while(nums[i]--!=0){
                            if(x[i]!=0){
                                x[2]--;
                                x[1]--;
                                x[0] -= 9;
                            }else{
                                sum++;
                                x[2] += 3;
                                x[1] += 5;
                                x[0] += 27;
                            }
                        }
                    }
                    if(i==1){
                        while(nums[i]--!=0){
                            if(x[1]!=0){
                                x[1]--;
                                x[0] -= 4;
                            }else{
                                sum++;
                                x[1] += 8;
                                x[0] += 32;
                            }
                        }
                    }
                    if(i==0){
                        while(nums[i]--!=0){
                            if(x[0]!=0){
                                x[0]--;
                            }else{
                                sum++;
                                x[0] += 35;
                            }
                        }
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
