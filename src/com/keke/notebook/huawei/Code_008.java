package com.keke.notebook.huawei;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by KEKE on 2019/6/22
 * 合并表记录
 * 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 */
public class Code_008 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i=0;i<n;i++){
            int key = in.nextInt();
            int value = in.nextInt();
            if (map.containsKey(key)){
                map.put(key,map.get(key)+value);
            }else {
                map.put(key,value);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
