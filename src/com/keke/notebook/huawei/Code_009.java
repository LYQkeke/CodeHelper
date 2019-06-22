package com.keke.notebook.huawei;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/22
 * 提取不重复的整数
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 */
public class Code_009 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] map = new int[10];
        String ans = "";
        String n = in.next();
        for(int i=n.length()-1;i>=0;i--){
            if(map[n.charAt(i)-'0']==0){
                ans += n.charAt(i);
                map[n.charAt(i)-'0'] = 1;
            }
        }
        while(ans.startsWith("0")){
            ans = ans.substring(1,ans.length());
        }
        System.out.println(ans.length()==0?0:ans);
    }
}
