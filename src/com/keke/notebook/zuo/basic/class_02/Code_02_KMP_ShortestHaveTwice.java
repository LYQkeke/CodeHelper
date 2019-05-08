package com.keke.notebook.zuo.basic.class_02;

/**
 * Created by KEKE on 2019/5/8
 *
 * KMP变型问题
 * 添加最短的字符串，使得str出现两次（只能在str的尾部添加）
 */
public class Code_02_KMP_ShortestHaveTwice {

    public static String answer(String str){
        if (str==null||str.length()==0)
            return "";
        if (str.length()==1)
            return str + str;
        char[] chars = str.toCharArray();
        if (str.length()==2){
            return chars[0]==chars[1]?str+chars[0]:str+str;
        }
        int i = getNextEnd(chars);
        return str+str.substring(i);
    }

    /**
     * 相比于KMP的getNext方法，多计算了以为，计算整个字符串的想桶的最长前缀和最长后缀长度
     * @param chs
     * @return
     */
    private static int getNextEnd(char[] chs){
        int[] next = new int[chs.length+1];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos<chs.length){
            if (chs[pos-1]==chs[cn]){
                next[pos++] = ++cn;
            }else if (cn>0){
                cn = next[cn];
            }else{
                next[pos++] = 0;
            }
        }
        return next[next.length-1];
    }
    public static void main(String[] args) {
        String test1 = "a";
        System.out.println(answer(test1));

        String test2 = "aa";
        System.out.println(answer(test2));

        String test3 = "ab";
        System.out.println(answer(test3));

        String test4 = "abcdabcd";
        System.out.println(answer(test4));

        String test5 = "abracadabra";
        System.out.println(answer(test5));
    }
}
