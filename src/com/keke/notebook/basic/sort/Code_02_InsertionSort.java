package com.keke.notebook.basic.sort;

import java.util.Arrays;

/**
 * Created by KEKE on 2019/7/4
 *
 * 插入排序
 * 在每一躺排序开始之前都保证开始位置之前保持有序
 * 然后将该元素插入到它应该处于的位置
 * 在最好的情况下，该方法的时间复杂度为O(n)
 * 最坏和平均情况下，该方法的时间复杂度为O(n^2)
 * 额外空间复杂度为O(1)
 * 是一种稳定的排序算法
 * 在待排序元素相对有序的情况下比较好
 * 原址排序
 */
public class Code_02_InsertionSort {

    public static void sort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int temp =arr[i];
            int j = i;
            while (j>0&&arr[j-1]>temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,5,3,7,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
