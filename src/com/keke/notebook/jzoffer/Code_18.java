package com.keke.notebook.jzoffer;

import com.keke.entity.TreeNode;

/**
 * Created by KEKE on 2019/5/22
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
 *         8
 *       /  \
 *      6   10
 *    / \  / \
 *   5  7 9 11
 * 镜像二叉树
 *         8
 *       /  \
 *     10   6
 *    / \  / \
 *   11 9 7  5
 */
public class Code_18 {
    public void Mirror(TreeNode root) {
        if(root==null)
            return;
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        Mirror(root.left);
        Mirror(root.right);
    }
}
