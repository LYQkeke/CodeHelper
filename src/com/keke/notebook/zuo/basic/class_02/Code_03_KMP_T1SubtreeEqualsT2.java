package com.keke.notebook.zuo.basic.class_02;

import com.keke.entity.TreeNode;

/**
 * Created by KEKE on 2019/5/8
 *
 * KMP变型问题
 * 判断T1中是否包含与T2相同的子树
 */
public class Code_03_KMP_T1SubtreeEqualsT2 {

    public static boolean isSubTree(TreeNode t1, TreeNode t2){
        String s1 = serialByPre(t1);
        String s2 = serialByPre(t2);
        return getIndexOf(s1,s2)!=-1;
    }

    private static String serialByPre(TreeNode t){
        if (t==null)
            return "#_";
        String s = t.val+"_";
        s += serialByPre(t.left);
        s += serialByPre(t.right);
        return s;
    }

    private static int getIndexOf(String s, String m){
        if (s==null||m==null||m.length()==0||s.length()<m.length())
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
        return mi==ms.length?si=mi:-1;
    }

    private static int[] getNext(char[] chs){
        if (chs.length==1)
            return new int[]{-1};
        int[] next= new int[chs.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos<chs.length){
            if (chs[pos-1]==chs[cn]){
                next[pos++] = ++cn;
            }else if (cn>0){
                cn = next[cn];
            }else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(7);
        t1.left.left.right = new TreeNode(8);
        t1.left.right.left = new TreeNode(9);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(4);
        t2.left.right = new TreeNode(8);
        t2.right = new TreeNode(5);
        t2.right.left = new TreeNode(9);

        System.out.println(isSubTree(t1,t2));
    }
}
