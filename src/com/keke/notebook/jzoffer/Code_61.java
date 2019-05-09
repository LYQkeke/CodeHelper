package com.keke.notebook.jzoffer;

import com.keke.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by KEKE on 2019/5/8
 *
 * 序列化二叉树and反序列化
 */
public class Code_61 {
    String Serialize(TreeNode root) {
        // 一定要添加分隔符，不然无法区分节点
        // 使用特殊字符标记空节点，可以使得序列化的二叉树能够唯一标识二叉树的结构
        if(root==null)
            return "#_";
        String s = "";
        // 先序序列化二叉树
        s += root.val + "_";
        s += Serialize(root.left);
        s += Serialize(root.right);
        return s;
    }

    TreeNode Deserialize(String str) {
        String[] vals = str.split("_");
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<vals.length;i++)
            queue.offer(vals[i]);
        return reSetPreOrder(queue);
    }

    /**
     * 使用什么顺序序列化，就使用什么顺序反序列化
     * @param queue
     * @return
     */
    private TreeNode reSetPreOrder(Queue<String> queue){
        String s = queue.poll();
        if(s.equals("#"))
            return null;
        TreeNode head = new TreeNode(Integer.parseInt(s));
        head.left = reSetPreOrder(queue);
        head.right = reSetPreOrder(queue);
        return head;
    }
}
