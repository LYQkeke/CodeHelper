package com.keke.notebook.c2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by KEKE on 2019/6/29
 * 去哪儿
 * BST判定
 */
public class Code_178 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rootNo = in.nextInt();
        // 防止输入序列是随机的，所以使用map来容纳节点
        Map<Integer,Node> map = new HashMap<>();
        int index = 6;
        while (index--!=0){
            String cur = in.next();
            int s1 = cur.indexOf(":");
            int s2 = cur.indexOf("|");
            int no = Integer.valueOf(cur.substring(0,s1));
            int left = Integer.valueOf(cur.substring(s1+1,s2));
            int right = Integer.valueOf(cur.substring(s2+1));
            Node temp = map.containsKey(no)?map.get(no):new Node(no);
            if (left!=-1){
                temp.left = map.containsKey(left)?map.get(left):new Node(left);
                map.put(left,temp.left);
            }
            if (right!=-1){
                temp.right = map.containsKey(right)?map.get(right):new Node(right);
                map.put(left,temp.right);
            }
            map.put(no,temp);
        }
        Node root = map.get(rootNo);
        System.out.println(isBST(root)?1:0);
    }

    private static boolean isBST(Node root){
        int max = -1;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node cur = root.left;
        while (cur!=null||!stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                if (stack.peek().val<=max){
                    return false;
                }else {
                    max = stack.peek().val;
                    cur = stack.pop().right;
                }
            }
        }
        return true;
    }

    private static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
}
