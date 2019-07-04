package com.keke.notebook.c2018;

import java.util.*;

/**
 * Created by KEKE on 2019/7/4
 * 招商银行信用卡
 * 卡中心美食家
 * 在卡中心隐藏了很多美食，作为一名资深吃货，楼主告诉你需要去品尝n道美味才能达成“卡中心小小美食家”的成就。这些菜品被标号为 0 到 n-1 。
 * 正所谓美食家不是一口吃成个胖子的，每道美味的品尝顺序也是有讲究的，比如西餐的上菜顺序：头盘，汤，副菜，主菜，蔬菜类菜肴，甜品，咖啡或茶。
 * 有一些美味需要“前置菜肴”，比如如果你要吃菜品0，你需要先吃菜品1
 * ，我们用一个范式来表示这些规则：[0 1]。接下来给你菜品的总数量n和m个“前置菜肴”的范式，请编程输出你为了品尝完所有美味所安排的进餐顺序。
 * 可能会有多个正确的顺序，你只要输出一种就可以了。如果不可能品尝完所有美味，返回None。
 */
public class Code_132 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Dish[] dishs = new Dish[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<dishs.length;i++){
            dishs[i] = new Dish();
        }
        for (int i = 0; i < m; i++) {
            int pos = in.nextInt();
            int pre = in.nextInt();
            dishs[pre].next.add(pos);
            dishs[pos].pres++;
        }
        for (int i=0;i<dishs.length;i++){
            if (dishs[i].pres==0){
                queue.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (queue.size()!=0){
            int curIndex = queue.poll();
            Dish cur = dishs[curIndex];
            for (Integer next: cur.next){
                if (--dishs[next].pres==0){
                    queue.offer(next);
                }
            }
            sb.append(","+curIndex);
            ++count;
        }
        System.out.println(count==n?sb.substring(1):"None");
    }

    private static class Dish{
        int pres = 0;
        List<Integer> next = new ArrayList<>();
    }
}
