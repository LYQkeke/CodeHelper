package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/7/4
 * 招商银行信用卡
 * 信用卡推荐客户列表
 * 现在信用卡开展营销活动，持有我行信用卡客户推荐新户办卡，开卡成功后可获得积分奖励。
 * 规定每个客户最多可推荐两个新户且一个新户只能被推荐一次。
 * 但允许链接效应，即若客户A推荐了新户B，新户B推荐新户C，则客户C同时属于A和B的推荐列表。
 * 简单起见，只考虑以一个  -- 老客户A --  作起点推荐的情况。编程计算推荐新户数不小于n的客户列表。
 */
public class Code_134 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);
        God[] gods = new God[26];
        for(int i=0;i<26;i++){
            gods[i] = new God();
        }
        for(int i=0;i<m;i++){
            String s = in.nextLine();
            char[] chs = s.toCharArray();
            int ad = chs[0] - 'A';
            int cs1 = chs[2] - 'A';
            gods[ad].left = gods[cs1];
//            solution(cs1,gods);
            if(chs[4]!='*'){
                int cs2 = chs[4] - 'A';
                gods[ad].right = gods[cs2];
//                solution(cs2,gods);
            }
        }
        traverse(gods[0]);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            if(gods[i].count>=n){
                sb.append(" "+(char)(i+'A'));
            }
        }
        System.out.println(sb.length()==0?"None":sb.substring(1));
    }

    private static int traverse(God god){
        if (god==null)
            return 0;
        int l = traverse(god.left);
        int r = traverse(god.right);
        god.count = l + r;
        return l+r+1;
    }

    private static class God{
        // 用这种方法如果不设-1，当n的值为0的情况，会输出所有的客户
        int count = -1;
        God left;
        God right;
    }
}
