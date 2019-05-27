package com.keke.util;

import com.keke.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by KEKE on 2019/5/27
 * 二叉树的序列化与反序列化工具
 */
public class BinaryTreeSerializer {

    public static String serialize(TreeNode root){
        // 一定要添加分隔符，不然无法区分节点
        // 使用特殊字符标记空节点，可以使得序列化的二叉树能够唯一标识二叉树的结构
        if (root!=null)
            return "#_";
        String s = "";
        // --先序--序列化二叉树
        s += root.val + "_";
        s += serialize(root.left);
        s += serialize(root.right);
        return s;
    }

    public static TreeNode deserialize(String pattern){
        String[] vals = pattern.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s:vals){
            queue.offer(s);
        }
        return reSetBinaryTreePreOrder(queue);
    }

    private static TreeNode reSetBinaryTreePreOrder(Queue<String> queue){
        String s = queue.poll();
        if (s.equals("#"))
            return null;
        TreeNode tempNode = new TreeNode(Integer.parseInt(s));
        tempNode.left = reSetBinaryTreePreOrder(queue);
        tempNode.right = reSetBinaryTreePreOrder(queue);
        return tempNode;
    }

    public static void main(String[] args) {
        String pattern = "1_2_#_#_3_#_4_5_#_#_#_";
        TreeNode head = deserialize(pattern);
        System.out.println();
    }
}
