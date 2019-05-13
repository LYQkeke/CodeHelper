package com.keke.notebook.zuo.other;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by KEKE on 2019/5/13
 *
 * 最大值减去最小值小于或等于 num 的子数组数量
 *
 */
public class Code_01 {

    public static int getNum1(int[] arr, int num){
        if (arr==null||arr.length==0)
            return 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (isValid(arr,i,j,num)){
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean isValid(int[] arr, int i, int j, int num){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int index = i; index <= j; index++){
            min = Math.min(arr[index],min);
            max = Math.max(arr[index],max);
        }
        return max - min > num ? false : true;
    }

    public static int getNum2(int[] arr, int num){
        if (arr==null||arr.length==0||num<0)
            return 0;
        int i = 0;
        int j = 0;
        int res = 0;
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();
        while (i<arr.length){
            while (j<arr.length){
                while (!maxQueue.isEmpty()&&arr[maxQueue.peekLast()]<=arr[j]){
                    maxQueue.pollLast();
                }
                maxQueue.addLast(j);
                while (!minQueue.isEmpty()&&arr[minQueue.peekLast()]>=arr[j]){
                    minQueue.pollLast();
                }
                minQueue.addLast(j);
                if (arr[maxQueue.getFirst()]-arr[minQueue.getFirst()]>num){
                    break;
                }
                j++;
            }
            if (maxQueue.peekFirst()==i)
                maxQueue.pollFirst();
            if (minQueue.peekFirst()==i)
                minQueue.pollFirst();
            res += j - i;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr1 = {2,4,5,1,3,4};
        int[] arr2 = {2,5,3,6,1,6,9,3,4,5,1};
        int[] arr3 = {1,9,1};
        System.out.println(getNum1(arr1,4));
        System.out.println(getNum1(arr2,4));
        System.out.println(getNum1(arr3,1));
        System.out.println(getNum2(arr1,4));
        System.out.println(getNum2(arr2,4));
        System.out.println(getNum2(arr3,1));
    }
}
