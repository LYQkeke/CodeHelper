package com.keke.notebook.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by KEKE on 2019/5/12
 *
 * 最小的k个数
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Code_29 {

    // 使用堆 O(nlogk)
    public static ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> ansList = new ArrayList<>(k);
        if (input==null||input.length==0||k>input.length||k==0)
            return ansList;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        for (int i=0;i<input.length;i++){
            if (maxHeap.size()<k)
                maxHeap.add(input[i]);
            else if (input[i]<maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(input[i]);
            }
        }
        ansList.addAll(maxHeap);
        return ansList;
    }

    // 快排思想 O(n)
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        if (input==null||k>input.length||input.length==0||k<=0)
            return ans;
        int p = getKth(input,k-1);
        for (int i = 0; i < input.length; i++) {
            if (input[i]<p)
                ans.add(input[i]);
        }
        while (ans.size()<k)
            ans.add(p);
        return ans;
    }

    private static int getKth(int[] arr, int k){
        int[] pos = partition(arr,0,arr.length-1);
        while (k<=pos[0]||k>=pos[1]){
            if (k<=pos[0]){
                pos = partition(arr,0,pos[0]);
            }else {
                pos = partition(arr,pos[1],arr.length-1);
            }
        }
        return arr[pos[0]+1];
    }

    private static int[] partition(int[] arr, int l, int r){
        swap(arr,l+(int)(Math.random()*(r-l+1)), r);
        int p = arr[r];
        int less = l - 1;
        int more = r + 1;
        int index = l;
        while (index<more){
            if (arr[index]<p){
                swap(arr,++less,index++);
            }else if (arr[index]>p){
                swap(arr,--more,index);
            }else {
                index++;
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
        int[] arr = {4,5,1,6,2,7,3,8};
        int[] arr1 = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution1(arr, 4);
        System.out.println(arrayList);
        System.out.println(GetLeastNumbers_Solution2(arr1,4));
    }
}
