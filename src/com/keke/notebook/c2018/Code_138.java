package com.keke.notebook.c2018;

import java.util.*;

/**
 * Created by KEKE on 2019/7/3
 * 招商银行信用卡
 * 潜在风险客户识别
 * 以边关系表示客户间的转账行为，若客户1向2转账，就认为存在1指向2的边。
 * 假设从某个客户1出发，沿着其任意转账关系边查找，若最终均可以到达终止客户(不存在帐务转出的客户)，则认为客户1是安全客户；否则认为客户1是潜在风险客户。
 * 即，所有处于转账关系环中的客户以及指向环中客户的客户节点均是潜在风险客户。
 */
public class Code_138 {

    private static int[][] edge;
    private static Set<Integer> dangers = new HashSet<>();
    private static Set<Integer> set = new HashSet<>();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        edge = new int[n+1][n+1];
        for(int i=0;i<m;i++){
            String curLine = in.next();
            int dotIndex = curLine.indexOf(",");
            edge[Integer.valueOf(curLine.substring(0,dotIndex))][Integer.valueOf(curLine.substring(dotIndex+1))] = 1;
        }
        for(int i=1;i<=n;i++){
            if (!dangers.contains(i)){
                set.clear();
                inCircle(i);
            }
        }
        if (dangers.size()==n)
            System.out.println("None");
        else {
            int index = 0;
            for (int i=1;i<=n;i++){
                if (!dangers.contains(i)){
                    if (++index==1){
                        System.out.print(i);
                    }else {
                        System.out.print(" "+i);
                    }
                }
            }
            System.out.println();
        }
    }

    private static void inCircle(int from){
        if (dangers.contains(from))
            return;
        set.add(from);
        for(int i=1;i<edge.length;i++){
            if (edge[from][i]==1){
                if (set.contains(i)||dangers.contains(i)){
                    dangers.addAll(set);
                    return;
                }else {
                    inCircle(i);
                }
            }
        }
    }
}
