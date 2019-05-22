package com.keke.notebook.jzoffer;

import com.keke.entity.TreeNode;

/**
 * Created by KEKE on 2019/5/22
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Code_17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root2==null||root1==null)
            return false;
        if(isSame(root1,root2))
            return true;
        else
            return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }

    private boolean isSame(TreeNode root1, TreeNode root2){
        // 如果待匹配部分为空，则匹配成功，因为空的部分不影响是不是子树
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        return (root1.val==root2.val)&&isSame(root1.left,root2.left)&&isSame(root1.right,root2.right);
    }
}
