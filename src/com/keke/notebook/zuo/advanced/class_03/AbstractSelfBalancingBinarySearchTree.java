package com.keke.notebook.zuo.advanced.class_03;

/**
 * Not implemented by zuochengyun
 *
 * Abstract class for self balancing binary search trees. Contains some methods
 * that is used for self balancing trees.
 *
 * @author Ignas Lelys
 * @created Jul 24, 2011
 *
 */
public abstract class AbstractSelfBalancingBinarySearchTree extends AbstractBinarySearchTree {

    /** 在自平衡二叉树中新增了二叉树的左旋和右旋操作 */

    /**
     * Rotate to the left.
     *
     * @param node Node on which to rotate.
     * @return Node that is in place of provided node after rotation.
     */
    protected Node rotateLeft(Node node) {
        // 进行左旋，node节点的右孩子一定不为空
        Node temp = node.right;
        temp.parent = node.parent;

        node.right = temp.left;
        if (node.right != null) {
            node.right.parent = node;
        }

        temp.left = node;
        node.parent = temp;

        // temp took over node's place so now its parent should point to temp
        if (temp.parent != null) {// 不是根节点
            // 恢复父节点的指向
            if (node == temp.parent.left) {
                temp.parent.left = temp;
            } else {
                temp.parent.right = temp;
            }
        } else {// 是根节点
            // root需要指向temp
            root = temp;
        }

        return temp;
    }

    /**
     * Rotate to the right.
     *
     * @param node Node on which to rotate.
     * @return Node that is in place of provided node after rotation.
     */
    protected Node rotateRight(Node node) {
        Node temp = node.left;
        temp.parent = node.parent;

        node.left = temp.right;
        if (node.left != null) {
            node.left.parent = node;
        }

        temp.right = node;
        node.parent = temp;

        // temp took over node's place so now its parent should point to temp
        if (temp.parent != null) {
            if (node == temp.parent.left) {
                temp.parent.left = temp;
            } else {
                temp.parent.right = temp;
            }
        } else {
            root = temp;
        }

        return temp;
    }

}