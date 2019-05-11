package com.keke.notebook.jzoffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by KEKE on 2019/5/11
 *
 * 滑动窗口最大值
 */
public class Code_64 {

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        // 特殊情况，返回一个空的Array
        if(num==null||num.length<size||size<=0)
            return new ArrayList<Integer>();
        ArrayList<Integer> ansList = new ArrayList<>(num.length-size+1);
        // 新建一个双端队列
        Deque<Integer> queue = new LinkedList<>();
        //queue.addLast(num[0]);
        for(int i=0;i<num.length;i++){
            while(queue.size()!=0&&num[queue.peekFirst()]<=num[i]){
                queue.pollFirst();
            }
            queue.addFirst(i);
            // 如果队列的尾部的值已经过期，那么让该值出队
            if(i-size==queue.peekLast())
                queue.pollLast();
            // 如果当前位置已经可以进行输出了，那么取队尾元素为当前窗口的最大值
            if(i>=size-1){
                ansList.add(num[queue.peekLast()]);
            }
        }
        return ansList;
    }
}
