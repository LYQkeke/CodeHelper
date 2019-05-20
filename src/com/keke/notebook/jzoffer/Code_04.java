package com.keke.notebook.jzoffer;

import com.keke.entity.TreeNode;

import java.util.HashMap;

/**
 * Created by KEKE on 2019/5/20
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都 # 不含重复的数字 # 。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Code_04 {

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre==null||in==null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<in.length;i++)
            map.put(in[i],i);
        return preIn(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }

    private TreeNode preIn(int[] pre, int pl, int pr, int[] in, int il, int ir, HashMap<Integer, Integer> map){

        if (pl>pr)
            return null;
        TreeNode head = new TreeNode(pre[pl]);
        int index = map.get(pre[pl]);
        head.left = preIn(pre, pl+1, pl+index-il, in, il, index-1, map);
        head.right = preIn(pre, pl+index+1-il, pr, in, index+1, ir, map );
        return head;
    }
}
