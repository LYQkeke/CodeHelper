package com.keke.notebook.jzoffer;

/**
 * Created by KEKE on 2019/5/24
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同
 */
public class Code_23 {
    public boolean VerifySquenceOfBST(int [] arr) {
        if(arr==null||arr.length==0)
            return false;
        return verifyBST(arr, 0, arr.length-1);
    }

    private boolean verifyBST(int[] arr, int l, int r){
        if(l==r)
            return true;
        int head = arr[r];
        int lCount = 0;
        for(;l+lCount<r;lCount++){
            if(arr[l+lCount]>head){
                break;
            }
        }
        for(int i=l+lCount;i<r;i++){
            if(arr[i]<head)
                return false;
        }
        boolean left = true;
        // 递归判断左子树
        if(lCount>0){
            left = verifyBST(arr,l,lCount+l-1);
        }
        boolean right = true;
        // 递归判断右子树
        if(l+lCount+1<r){
            right = verifyBST(arr,l+lCount,r-1);
        }
        return (left&&right);
    }
}
