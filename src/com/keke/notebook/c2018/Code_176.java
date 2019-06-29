package com.keke.notebook.c2018;

import java.util.*;

/**
 * Created by KEKE on 2019/6/29
 * 去哪儿
 * 带权的DAG节点排序
 * DAG即Directed Acyclic Graph,有向无环图.用DAG可以描述一些有依赖关系的任务组,而这些任务还有另外一个属性,即都有一个权重,标示这个任务的重要性.
 * 我们需要你来实现一个算法,对DAG里面的节点进行排序,保证排序不违背DAG的依赖关系,
 * 即一个任务A如果排在任务B前面,那么在DAG中不能存在由B到A的路径.
 * 另外一个要求就是,让权重大的任务尽量优先执行.
 */
public class Code_176 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();
        Node[] nodes = new Node[n+1];
        PriorityQueue<Node> maxHeap = new PriorityQueue<>();
        for (int i=0;i<n;i++){
            int no = in.nextInt();
            nodes[no] = new Node(no, in.nextInt());
        }
        for (int i=0;i<e;i++){
            int from = in.nextInt();
            int to = in.nextInt();
            nodes[from].next.add(nodes[to]);
            nodes[to].inDegree++;
        }
        // 向最大堆中添加入度为0的节点
        for (int i = 1; i <= n; i++) {
            if (nodes[i].inDegree==0){
                maxHeap.offer(nodes[i]);
            }
        }
        int count = 0;
        while (maxHeap.size()!=0){
            Node curMax = maxHeap.poll();
            for (Node cur: curMax.next){
                // 当前入度不为0，并且
                if (cur.inDegree!=0&&--cur.inDegree==0){
                    maxHeap.offer(cur);
                }
            }
            // 输出
            System.out.print(curMax.no);
            if (++count!=n){
                System.out.print(" ");
            }
        }
    }

    private static class Node implements Comparable<Node>{
        Integer value;
        Integer no;
        int inDegree = 0;
        List<Node> next = new ArrayList<>();
        Node(Integer no,int value) {
            this.value = value;
            this.no = no;
        }

        @Override
        public int compareTo(Node o) {
            return -Integer.compare(value,o.value);
        }
    }
}
