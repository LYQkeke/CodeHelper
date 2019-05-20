package com.keke.notebook.jzoffer;

/**
 * Created by KEKE on 2019/5/20
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class Code_02 {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        char[] chars = s.toCharArray();
        int len = 0;
        for (char c:chars){
            if (c==' ')
                len += 3;
            else
                len++;
        }
        char[] chars1 = new char[len];
        int j = len-1;
        // 从后往前,这个方法对很多字符串问题都是有效的
        for (int i=chars.length-1;i>=0;i--){
            if (chars[i]==' '){
                chars1[j--]='0';
                chars1[j--]='2';
                chars1[j--]='%';
            }else
                chars1[j--]=chars[i];
        }
        return new String(chars1);
    }
}
