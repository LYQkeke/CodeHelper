package com.keke.notebook.basic.sort;

import java.util.Arrays;

/**
 * Created by KEKE on 2019/7/4
 *
 * 冒泡排序
 * 冒泡排序顾名思义，利用类似冒泡的过程在每一趟排序的过程中，将最大或者最小的元素放到最后
 * 最好的情况下时间复杂度为O(n)，最坏和平均的情况下平均时间复杂度为O(n^2)
 * 额外空间复杂度为O(1)
 * 是一种稳定的排序算法
 * 是原址排序（在数组的本身上进行排序）
 *
 */
public class Code_01_BubbleSort {

    public static void sort(int[] arr){
        boolean moved = false;
        for (int i=arr.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
            if (!moved)
                return;
            else
                moved = false;
        }
    }

    public static void swap(int[] arr, int i, int j){
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
