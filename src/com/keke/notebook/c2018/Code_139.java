package com.keke.notebook.c2018;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/21
 * 滴滴
 * 整数无序数组求第k大数
 */
public class Code_139 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] numStrings = in.nextLine().split(" ");
        int k = in.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(String numString:numStrings){
            int num = Integer.valueOf(numString);
            if (pq.size()<k)
                pq.offer(num);
            else if(num>pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        System.out.println(pq.poll());
    }
}
