package com.keke.notebook.zuo.basic.class_01;

import java.util.Arrays;

/**
 * Created by KEKE on 2019/5/10
 *
 * 荷兰国旗问题
 * 把数组中小于p的数放在左边，大于p的数放在右边
 */
public class Code_08_NetherlandFlag {

    public static int[] partition(int[] arr, int l, int r, int p){
        int less = l - 1;
        int more = r + 1;
        int i = l;
        while (i<more){
            if (arr[i]<p){
                swap(arr,++less,i++);
            }else if (arr[i]>p){
                swap(arr,--more,i);
            }else {
                i++;
            }
        }
        return new int[]{less,more};
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {3,7,9,3,1,6,3,7,8,2};
        System.out.println(Arrays.toString(arr));
        int[] p = partition(arr,0,arr.length-1,3);
        System.out.println(Arrays.toString(arr));
        System.out.println(p[0]);
        System.out.println(p[1]);
    }
}
