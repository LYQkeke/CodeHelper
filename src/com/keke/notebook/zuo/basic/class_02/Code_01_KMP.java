package com.keke.notebook.zuo.basic.class_02;

/**
 * Created by KEKE on 2019/5/8
 *
 * 字符串的KMP匹配
 */
public class Code_01_KMP {

    public static int getIndexOf(String s, String m){

        if (s==null||m==null||m.length()<1||s.length()<m.length())
            return -1;
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNext(ms);
        while (si<ss.length&&mi<ms.length){
            if (ss[si]==ms[mi]){
                ++si;
                ++mi;
            }else if (next[mi]>=0){
                mi = next[mi];
            }else {
                ++si;
            }
        }
        return mi==ms.length?si-mi:-1;
    }

    private static int[] getNext(char[] chs){
        if (chs.length==1)
            return new int[]{-1};
        int[] next = new int[chs.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos<chs.length){
            if (chs[pos-1]==chs[cn]){
                next[pos++] = cn + 1;
            }else if (cn>0){
                cn = next[cn];
            }else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));
    }
}
