package com.keke.notebook.zuo.other;

import java.util.Stack;

/**
 * Created by KEKE on 2019/5/13
 *
 * 求最大子矩阵的大小
 * 如：1 1 1 0  ->  3
 * 再如： 1 0 1 1
 *        1 1 1 1  -> 6
 *        1 1 1 0
 */
public class Code_02 {

    public static int maxRecSize(int[][] map){
        if (map==null||map.length==0||map[0].length==0)
            return 0;
        int[] height = new int[map[0].length];
        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j]==1 ? height[j]+1 : 0;
            }
            maxSize = Math.max(maxSize,maxRecFromBottom(height));
        }
        return maxSize;
    }

    public static int maxRecFromBottom(int[] height){
        if (height==null||height.length==0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int maxRec = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty()&&height[i]<=height[stack.peek()]){
                int h = stack.pop();
                int l = stack.isEmpty()?-1:stack.peek();
                maxRec = Math.max(maxRec,height[h]*(i-l-1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int h = stack.pop();
            int l = stack.isEmpty()?-1:stack.peek();
            maxRec = Math.max(maxRec,height[h]*(height.length-l-1));
        }
        return maxRec;
    }

    public static void main(String[] args) {
        int[][] map1 = {{1,1,1,0}};
        int[][] map2 = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        System.out.println(maxRecSize(map1));
        System.out.println(maxRecSize(map2));
    }
}
