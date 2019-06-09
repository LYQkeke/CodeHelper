package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/8
 * 拼多多
 * 列表补全
 * 在商城的某个位置有一个商品列表，该列表是由L1、L2两个子列表拼接而成。当用户浏览并翻页时，需要从列表L1、L2中获取商品进行展示。展示规则如下：
 *
 * 1. 用户可以进行多次翻页，用offset表示用户在之前页面已经浏览的商品数量，比如offset为4，表示用户已经看了4个商品
 *
 * 2. n表示当前页面需要展示的商品数量
 *
 * 3. 展示商品时首先使用列表L1，如果列表L1长度不够，再从列表L2中选取商品
 *
 * 4. 从列表L2中补全商品时，也可能存在数量不足的情况
 *
 * 请根据上述规则，计算列表L1和L2中哪些商品在当前页面被展示了
 */
public class Code_055 {
    //情况太复杂
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int offset = in.nextInt();
            int n = in.nextInt();
            int l1 = in.nextInt();
            int l2 = in.nextInt();
            int start1=l1,start2=l2,end1=l1,end2=l2;
            if(n==0&&offset==0){
                System.out.println(0+" "+0+" "+0+" "+0);
                return;
            }
            if(offset>=l1+l2){
                System.out.println(l1+" "+l1+" "+l2+" "+l2);
                return;
            }
            if(offset<=l1){
                start1 = offset;
                if(offset+n<=l1){
                    end1 = offset + n;
                    start2 = 0;
                    end2 = 0;
                    n = 0;
                }else{
                    end1 = l1;
                    n = n - l1 + offset;
                    offset = 0;
                }
            }
            if(n>0){
                start2 = offset;
                if(offset+n<=l2){
                    end2 = offset+n;
                }else{
                    end2 = l2;
                }
            }
            System.out.println(start1+" "+end1+" "+start2+" "+end2);
        }
    }
}
