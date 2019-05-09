package com.keke.notebook.zuo.basic.class_02;

/**
 * Created by KEKE on 2019/5/8
 */
public class Code_04_Manacher {

    private static char[] manacherString(String str){
        char[] chs = str.toCharArray();
        char[] manacher = new char[2*chs.length+1];
        int index = 0;
        for (int i = 0; i < manacher.length; i++) {
            // 偶数位 # 奇数位 字符串原始字符
            manacher[i] = (i&1)==0 ? '#' : chs[index++];
        }
        return manacher;
    }

    public static int maxLcpsLength(String str){
        if (str==null||str.length()==0)
            return 0;
        char[] chs = manacherString(str);
        int[] pArr = new int[chs.length]; // 回文半径数组
        int pR  = -1; // 回文右边界即将到达的位置
        int index = -1; // 上一次更新回文右边界的位置
        int max = Integer.MIN_VALUE; // 记录当前最长回文子串的长度
        for (int i = 0; i < chs.length; i++) {
            pArr[i] = pR>i ? Math.min(pR-i,pArr[2*index-i]) : 1;
            while (i+pArr[i]<chs.length&&i-pArr[i]>-1){
                if(chs[i+pArr[i]]==chs[i-pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if (i+pArr[i]>pR){
                pR = i+pArr[i];
                index = i;
            }
            max = Math.max(max,pArr[i]);
            // 当回文串右边界到达字符串结尾就可以结束了，因为不能存在更长的可能
            // 我觉得是这个样子，具体可能还要用对数器试一下
            if (pR==chs.length)
                break;
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        // 正确答案应该为7
        System.out.println(maxLcpsLength(str1));
        System.out.println(maxLcpsLength(""));
        System.out.println(maxLcpsLength("a"));
        System.out.println(maxLcpsLength("aa"));
    }
}
