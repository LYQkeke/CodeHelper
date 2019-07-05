package com.keke.notebook.basic.sort;

import java.util.Arrays;

/**
 * Created by KEKE on 2019/7/4
 *
 * 快速排序
 * 快速排序和归并排序类似，都是采用分而治之的思想，但是划分的方法不同
 * 在最坏情况下快速排序的时间复杂度为O(n^2)
 * 在最好和平均情况的时间复杂度为O(nlogn)
 * 由于使用了递归方法，所以需要使用递归栈 额外空间复杂度O(logn)
 * 是一种不稳定的排序算法
 * 原址排序
 */
public class Code_06_QuickSort {

    public static void sort(int[] arr){
        quickSort(arr,0, arr.length-1);
    }

    private static void quickSort(int[] arr, int l, int r){
        if (l<r){
//            int[] p = netherlandPartition(arr,l,r,arr[r]);
//            quickSort(arr,l,p[0]);
//            quickSort(arr,p[1],r);
            int p = partition(arr, l, r);
            quickSort(arr,l,p-1);
            quickSort(arr,p+1,r);
        }
    }

    private static int[] netherlandPartition(int[] arr, int l, int r, int p){
        int less = l - 1;
        int more = r + 1;
        int i = l;
        while (i<more){
            if (arr[i]<p){
                swap(arr,++less, i++);
            }else if (arr[i]>p){
                swap(arr,--more, i);
            }else {
                ++i;
            }
        }
        return new int[]{less,more};
    }

    private static int partition(int[] arr, int l, int r){
        int less = l - 1;
        int more = r;
        int p = arr[r];
        int i = l;
        while (i<more){
            if (arr[i]<=p){
                swap(arr,++less,i++);
            }else {
                swap(arr,--more,i);
            }
        }
        swap(arr,more,r);
        return more;
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
