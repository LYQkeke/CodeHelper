package com.keke.notebook.jzoffer;

import com.keke.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by KEKE on 2019/5/24
 * 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。-- 层次遍历
 * 队列 FILO
 */
public class Code_22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ansList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root!=null){
            ansList.add(root.val);
            if(root.left!=null)
                queue.add(root.left);
            if(root.right!=null)
                queue.add(root.right);
            TreeNode cur;
            while(!queue.isEmpty()){
                cur = queue.remove();
                ansList.add(cur.val);
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
        }
        return ansList;
    }
}
