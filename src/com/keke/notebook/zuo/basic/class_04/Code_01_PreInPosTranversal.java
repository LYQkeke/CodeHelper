package com.keke.notebook.zuo.basic.class_04;

import com.keke.entity.TreeNode;
import com.keke.util.BinaryTreeSerializer;

import java.util.Stack;

/**
 * Created by KEKE on 2019/5/27
 * 二叉树的遍历
 * 递归和非递归
 * 前中后
 */
public class Code_01_PreInPosTranversal {

    /**
     * 递归先序遍历
     * @param root
     */
    public static void preOrderRecur(TreeNode root){
        if (root == null)
            return;
        System.out.print(root.val+" ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    /**
     * 递归中序遍历
     * @param root
     */
    public static void inOrderRecur(TreeNode root){
        if (root==null)
            return;
        inOrderRecur(root.left);
        System.out.print(root.val+" ");
        inOrderRecur(root.right);
    }

    /**
     * 递归后序遍历
     * @param root
     */
    public static void posOrderRecur(TreeNode root){
        if (root==null)
            return;
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.print(root.val+" ");
    }

    /**
     * 非递归先序遍历
     * 使用栈来模拟递归出入栈的过程
     * @param root
     */
    public static void preOrderUnRecur(TreeNode root){
        System.out.print("pre: ");
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode curNode = stack.pop();
                System.out.print(curNode.val+" ");
                if (curNode.right!=null)
                    stack.push(curNode.right);
                if (curNode.left!=null)
                    stack.push(curNode.left);
            }
        }
        System.out.println();
    }

    public static void inOrderUnRecur(TreeNode root){
        System.out.print("in: ");
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur!=null||!stack.isEmpty()){
                if (cur!=null){
                    stack.push(cur);
                    cur = cur.left;
                }else {
                    cur = stack.pop();
                    System.out.print(cur.val+" ");
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur1(TreeNode root){
        System.out.print("pos-1stack: ");
        if (root!=null){
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            TreeNode tempNode = null;
            while (!stack1.isEmpty()){
                tempNode = stack1.pop();
                if (tempNode.left!=null){
                    stack1.push(tempNode.left);
                }
                if (tempNode.right!=null){
                    stack1.push(tempNode.right);
                }
                stack2.push(tempNode);
            }
            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().val+" ");
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur2(TreeNode root){
        System.out.print("pos-2stack: ");
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode lastPrint = root;
            TreeNode curNode = null;
            stack.push(root);
            while (!stack.isEmpty()){
                curNode = stack.peek();
                if (curNode.left!=null&&lastPrint!=curNode.left&&lastPrint!=curNode.right){
                    stack.push(curNode.left);
                }else if (curNode.right!=null&&lastPrint!=curNode.right){
                    stack.push(curNode.right);
                }else {
                    System.out.print(stack.pop().val+" ");
                    lastPrint = curNode;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /**
         * pre: 1 2 3 4 5
         * in:  2 1 3 5 4
         * pos: 2 5 4 3 1
         */
        String pattern = "1_2_#_#_3_#_4_5_#_#_#_";
        TreeNode head = BinaryTreeSerializer.deserialize(pattern);
        preOrderRecur(head);
        System.out.println();
        inOrderRecur(head);
        System.out.println();
        posOrderRecur(head);
        System.out.println();
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);
    }
}
