package com.keke.notebook.zuo.basic.class_02;

/**
 * Created by KEKE on 2019/5/9
 *
 * 在字符串的最后添加最少字符，使得整个字符串都成为回文串
 * 本题的关键在于寻找包含字符串结尾字符的最大回文半径
 */
public class Code_05_Manacher_ShortestEnd {

    public static char[] manacherString(String str) {
        char[] chs = str.toCharArray();
        char[] manacher = new char[chs.length*2+1];
        int index = 0;
        for (int i = 0; i < manacher.length; i++) {
            manacher[i] = (i&1)==0 ? '#' : chs[index++];
        }
        return manacher;
    }

    public static String shortestEnd(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] chs = manacherString(str);
        int[] pArr = new int[chs.length];
        int index = -1;
        int pR = -1;
        int max = -1;
        for (int i = 0; i < chs.length; i++) {
            pArr[i] = pR>i ? Math.min(pR-i,pArr[2*index-i]) : 1;
            while (i+pArr[i]<chs.length&&i-pArr[i]>-1){
                if (chs[i-pArr[i]]==chs[i+pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i+pArr[i]>pR){
                pR = i+pArr[i];
                index = i;
            }
            if (pR == chs.length){
                max = pArr[index]-1;
                break;
            }
        }
        String ans = "";
        index = str.length()-max-1;
        for (;index>=0;index--){
            ans += chs[2*index+1];
        }
        return "#" + ans + "#";
    }

    public static void main(String[] args) {
        String str2 = "abcd123321";
        System.out.println(shortestEnd(str2));
        System.out.println(shortestEnd("121"));
        System.out.println(shortestEnd("1212"));
    }
}
