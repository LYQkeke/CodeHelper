package com.keke.notebook.zuo.basic.class_01;

import com.keke.util.RandSampleGenerator;

import java.util.Arrays;

/**
 * Created by KEKE on 2019/5/10
 *
 *  快速排序
 */
public class Code_04_QuickSort {

    public static void quickSort(int[] arr){
        if (arr==null||arr.length<2)
            return;
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int l, int r){
        if (l<r){
            swap(arr,l + (int)(Math.random()*(r-l+1)),r);
            int[] p = partition(arr,l,r,arr[r]);
            // 所有跟中间值相同的元素不用重复进行计算了
            quickSort(arr,l,p[0]);
            quickSort(arr,p[1],r);
        }
    }

    // partition 荷兰国旗问题中的解法
    private static int[] partition(int[] arr, int l, int r, int p){
        int less = l - 1;
        int more = r + 1;
        int i = l;
        while (i<more){
            if (arr[i]<p){
                swap(arr,++less,i++);
            }else if (arr[i]>p){
                swap(arr,--more,i);
            }else
                i++;
        }
        return new int[]{less,more};
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = RandSampleGenerator.generateRandomIntegerArray(20,10,false);
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
