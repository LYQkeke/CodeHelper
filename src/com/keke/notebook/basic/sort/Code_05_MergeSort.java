package com.keke.notebook.basic.sort;

import java.util.Arrays;

/**
 * Created by KEKE on 2019/7/4
 *
 * 归并排序
 * 归并排序利用递归和分治的思想将待排序的数组划分为半子表
 * 然后将两个有序的半子表进行合并
 * 在最坏、最好和平均的情况下 算法的时间复杂度都是O(nlogn)
 * 额外空间复杂度为O(n)
 * 是一种稳定的排序算法
 * 但是不是原址排序
 */
public class Code_05_MergeSort {

    public static void sort(int[] arr){
        if (arr==null||arr.length==1)
            return;
        msort(arr,0,arr.length-1);
    }

    private static void msort(int[] arr, int from, int to){
        if (from==to)
            return;
        int mid = from + (to-from)/2;
        msort(arr,from,mid);
        msort(arr,mid+1,to);
        merge(arr,from,mid+1,to);
    }

    private static void merge(int[] arr, int lhead, int rhead, int ed){
        int[] arrl = new int[rhead-lhead];
        int[] arrr = new int[ed-rhead+1];
        for (int i=0;i<arrl.length;i++){
            arrl[i] = arr[lhead+i];
        }
        for (int i=0;i<arrr.length;i++){
            arrr[i] = arr[rhead+i];
        }
        int li = 0,ri = 0,temp = lhead;
        while (li<arrl.length||ri<arrr.length){
            if (li==arrl.length){
                arr[temp++] = arrr[ri++];
            }else if (ri==arrr.length){
                arr[temp++] = arrl[li++];
            }else {
                if (arrl[li]<=arrr[ri]){
                    arr[temp++] = arrl[li++];
                }else {
                    arr[temp++] = arrr[ri++];
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {2,5,3,7,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
