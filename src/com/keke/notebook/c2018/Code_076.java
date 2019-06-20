package com.keke.notebook.c2018;

import java.util.*;

/**
 * Created by KEKE on 2019/6/20
 * 美团点评
 * 公交车
 */
public class Code_076 {
    private static ArrayList<Integer>[] stations;
    private static ArrayList<Integer>[] buses;
    private static Set<Integer> set;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        stations = new ArrayList[n+1];
        buses = new ArrayList[m+1];
        set = new HashSet<>();
        for(int i=2;i<=n;i++){
            set.add(i);
        }
        for(int i=1;i<=m;i++){
            buses[i] = new ArrayList<>();
            int c = in.nextInt();
            for(int j=1;j<=c;j++){
                int temp = in.nextInt();
                if(stations[temp]==null){
                    stations[temp] = new ArrayList<>();
                }
                stations[temp].add(i);
                buses[i].add(temp);
            }
        }
        dfs();
    }

    private static void dfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1,0));
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            // 遍历经过该station所有公交线路
            for (Integer bus:stations[cur.id]){
                // 遍历该线路可以到达的所有站点
                for(Integer station:buses[bus]){
                    if(cur.id!=station&&set.contains(station)){
                        if (station==stations.length-1){
                            System.out.println(cur.dis+1);
                            return;
                        }
                        // 从set中移除该节点
                        set.remove(station);
                        // 将该节点加入队列中
                        queue.offer(new Node(station,cur.dis+1));
//                        System.out.println(station);
                    }
                }
            }
        }
    }

    private static class Node{
        int id;
        int dis;
        Node(int id, int dis){
            this.id = id;
            this.dis = dis;
        }
    }
}
