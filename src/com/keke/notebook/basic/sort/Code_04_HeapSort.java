package com.keke.notebook.basic.sort;

import java.util.Arrays;

/**
 * Created by KEKE on 2019/7/4
 *
 * 堆排序
 * 堆排序在最坏、平均和最好情况下的时间复杂度都是O(nlogn)
 * 额外空间复杂度为O(1)
 * 不是稳定的排序算法
 * 原址排序
 */
public class Code_04_HeapSort {

    public static void sort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        // 建堆
        for (int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while (size>0){
            heapify(arr,0,size);
            swap(arr,0,--size);
        }
    }

    private static void heapInsert(int[] arr, int index){
        // -1/2 = 0
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    private static void heapify(int[] arr, int index, int size){
        int left = 2*index+1;
        while (left<size){
            int largest = left+1<size&&arr[left+1]>arr[left]?left+1:left;
            largest = arr[index]>arr[largest]?index:largest;
            if (largest==index)
                break;
            swap(arr,index,largest);
            index = largest;
            left = 2*index+1;
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
