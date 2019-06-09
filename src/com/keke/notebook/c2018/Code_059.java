package com.keke.notebook.c2018;

import java.util.*;

/**
 * Created by KEKE on 2019/6/9
 * 拼多多
 * 小熊吃糖
 * 有n只小熊，他们有着各不相同的战斗力。每次他们吃糖时，会按照战斗力来排，战斗力高的小熊拥有优先选择权。前面的小熊吃饱了，后面的小熊才能吃。每只小熊有一个饥饿值，每次进食的时候，小熊们会选择最大的能填饱自己当前饥饿值的那颗糖来吃，可能吃完没饱会重复上述过程，但不会选择吃撑。
 * 现在给出n只小熊的战斗力和饥饿值，并且给出m颗糖能填饱的饥饿值。
 * 求所有小熊进食完之后，每只小熊剩余的饥饿值。
 */
public class Code_059 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Bear[] bears = new Bear[n];
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            int w = in.nextInt();
            Integer temp;
            if ((temp=treeMap.get(w))==null){
                treeMap.put(w,1);
            }else {
                treeMap.put(w,temp+1);
            }
        }
        for (int i=0;i<n;i++){
            bears[i] = new Bear(i,in.nextInt(),in.nextInt());
        }
        // 按照战斗力排序
        Arrays.sort(bears, new Comparator<Bear>() {
            @Override
            public int compare(Bear o1, Bear o2) {
                return Integer.compare(o1.f,o2.f);
            }
        });
        for (int i = n-1; i >= 0; i--) {
            while (treeMap.size()>0){
                if (!eat(bears[i],treeMap))
                    break;
            }
        }
        Arrays.sort(bears, new Comparator<Bear>() {
            @Override
            public int compare(Bear o1, Bear o2) {
                return Integer.compare(o1.id,o2.id);
            }
        });
        for (Bear bear:bears){
            System.out.println(bear.h);
        }
    }

    private static boolean eat(Bear bear, TreeMap<Integer,Integer> treeMap){
        if (treeMap.size()==0)
            return false;
        Integer num,lastKey;
        num = treeMap.get(bear.h);
        if (num!=null){
            if (num==1){
                treeMap.remove(bear.h);
            }else{
                treeMap.put(bear.h,--num);
            }
            bear.h = 0;
            return true;
        }else{
            lastKey = treeMap.lowerKey(bear.h);
            if (lastKey==null){
                return false;
            }else {
                num = treeMap.get(lastKey);
                bear.h = bear.h - lastKey;
                if (num==1){
                    treeMap.remove(lastKey);
                }else {
                    treeMap.put(lastKey,--num);
                }
                return true;
            }
        }
    }

    static class Bear{
        int id;
        int f;
        int h;
        public Bear(int id, int f, int h) {
            this.id = id;
            this.f = f;
            this.h = h;
        }
    }
}
