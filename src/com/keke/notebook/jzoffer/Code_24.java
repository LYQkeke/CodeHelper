package com.keke.notebook.jzoffer;

import com.keke.entity.TreeNode;

import java.util.ArrayList;

/**
 * Created by KEKE on 2019/5/24
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Code_24 {
    private ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    int cur = 0;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null)
            return ansList;
        list.add(root.val);
        cur += root.val;
        if(cur == target&&root.left==null&&root.right==null)
            ansList.add(new ArrayList<Integer>(list));
        FindPath(root.left,target);
        FindPath(root.right,target);
        cur -= root.val;
        list.remove(list.size()-1);
        return ansList;
    }
}
