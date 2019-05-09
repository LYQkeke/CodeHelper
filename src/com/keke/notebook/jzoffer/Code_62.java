package com.keke.notebook.jzoffer;

import com.keke.entity.TreeNode;

import java.util.Stack;

/**
 * Created by KEKE on 2019/5/9
 *
 * 二叉搜索树的第k个节点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4
 */
public class Code_62 {

    /**
     * 通过非递归中序遍历实现
     * @param root
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode root, int k)
    {
        if(root==null||k<1)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode temp = null;
        int cnt = 0;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                temp = stack.pop();
                if(++cnt==k)
                    return temp;
                else
                    cur = temp.right;
            }
        }
        return null;
    }
}
