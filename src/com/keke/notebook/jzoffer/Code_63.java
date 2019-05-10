package com.keke.notebook.jzoffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by KEKE on 2019/5/10
 *
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数
 */
public class Code_63 {

    // 这是一个最大堆
    private PriorityQueue<Integer> lessHeap = new PriorityQueue<>(new Comparator<Integer>(){
        public int compare(Integer o1, Integer o2){
            return -Integer.compare(o1,o2);
        }
    });

    // 这是一个最小堆
    private PriorityQueue<Integer> moreHeap = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (lessHeap.size()==0)
            lessHeap.add(num);
        else if (num>lessHeap.peek()){
            moreHeap.add(num);
            if (moreHeap.size()-lessHeap.size()>1)
                lessHeap.add(moreHeap.poll());
        }else {
            lessHeap.add(num);
            if (lessHeap.size()-moreHeap.size()>1)
                moreHeap.add(lessHeap.poll());
        }
    }

    public Double GetMedian() {
        if (moreHeap.size()==0 && lessHeap.size()==0)
            return 0.0;
        else if (moreHeap.size()>lessHeap.size())
            return moreHeap.peek().doubleValue();
        else if (lessHeap.size()>moreHeap.size())
            return lessHeap.peek().doubleValue();
        else
            return (lessHeap.peek()+moreHeap.peek())/2.0;
    }
}
