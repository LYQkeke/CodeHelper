package com.keke.notebook.c2018;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/7/4
 * 招商银行信用卡
 * 科室素拓活动
 * 科室素拓进行游戏，游戏规则如下：随机抽取9个人作为游戏参与人员，分别编号1至9，每轮要求k(k<=9且k>=0)个人自由组合使编号之和为n。
 * 输出满足规则的所有可能的组合。
 * 要求组合内部编号升序输出，组合之间无顺序要求。
 */
public class Code_133 {

    private static List<Integer> ans = new ArrayList<>(9);

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        if (!search(1,k,0,n)){
            System.out.println("None");
        }
    }

    private static boolean search(int i, int k,int sum, int target){
        if (k==0&&sum==target){
            print();
            return true;
        }
        if ((9-i+1)>=k&&sum+i<=target){
            ans.add(i);
            boolean b1 = search(i+1,k-1,sum+i,target);
            ans.remove(ans.size()-1);
            boolean b2 = search(i+1, k, sum, target);
            return b1||b2;
        }
        return false;
    }

    private static void print(){
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iterator = ans.iterator();
        while (iterator.hasNext()){
            sb.append(" "+iterator.next());
        }
        System.out.println(sb.substring(1));
    }
}
