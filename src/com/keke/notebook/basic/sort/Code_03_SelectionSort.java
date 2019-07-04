package com.keke.notebook.basic.sort;

import java.util.Arrays;

/**
 * Created by KEKE on 2019/7/4
 *
 * 选择排序
 * 选择排序在每一趟排序过程中选择候选对象中最小的一个，放到最前面
 * 选择排序在最坏、最好和平均情况下的时间复杂度都是O(n^2)
 * 额外空间复杂度O(1)
 * 并不是稳定的排序算法，在前几轮的选择过程中可能会将前面的元素放到后面
 * 在n比较小的时候使用比较好
 * 原址排序
 */
public class Code_03_SelectionSort {

    public static void sort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                swap(arr,i,minIndex);
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,3,7,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
