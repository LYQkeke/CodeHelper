package com.keke.notebook.jzoffer;

/**
 * Created by KEKE on 2019/5/20
 * 调整数组顺序使得奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Code_13 {
    /**
     * 借助辅助空间，时间复杂度O(N)
     * 使用冒泡\插入排序的思想可以在额外空间复杂度O(1)下，实现O(N^2)的算法
     */
    public void reOrderArray1(int [] array) {
        int len = array.length;
        int[] arr = new int[len];
        int l = 0;
        int r = len-1;
        for(int i=0;i<len;i++){
            boolean odd = ((array[i]&1)==0)?false:true;
            if(odd)
                arr[l++] = array[i];
        }
        for(int i=len-1;i>=0;i--){
            boolean odd = ((array[i]&1)==0)?false:true;
            if(!odd)
                arr[r--] = array[i];
        }
        for(int i=0;i<len;i++)
            array[i] = arr[i];
    }

    public void reOrderArray2(int[] array){
        if(array.length<=2)
            return;
        for(int i=1;i<array.length;i++){
            for(int j=i-1;j>=0;j--){
                if((array[j]&1)==0&&(array[j+1]&1)!=0){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
