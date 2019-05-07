package com.keke.util;

/**
 * 随机样本生成
 * Created by KEKE on 2019/5/7
 */
public class RandSampleGenerator {

    /**
     * 生成一个随机数组
     * @param maxSize
     * @param maxValule
     * @param negable 表示是否可以包含负数元素
     * @return
     */
    public static int[] generateRandomIntegerArray(int maxSize, int maxValule, boolean negable){
        int[] arr = new int[(int)( (maxSize+1)*Math.random() )];
        for (int i = 0; i < arr.length; i++) {
            if (negable)
                arr[i] = (int)((maxValule+1)*Math.random()) - (int)(maxValule*Math.random());
            else
                arr[i] = (int)((maxValule+1)*Math.random());
        }
        return arr;
    }

    /**
     * 生成随机二维矩阵
     * @param maxRowColSize
     * @param squre 是否生成方阵
     * @return
     */
    public static int[][] generateRandomIntegerMatrix(int maxRowColSize, boolean squre){
        int[][] result;
        if (squre){
            int size = (int)(Math.random()*maxRowColSize+1);
            result  = new int[size][size];
        }else {
            result = new int[(int)(Math.random()*maxRowColSize+1)][(int)(Math.random()*maxRowColSize+1)];
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = (int)(Math.random()*10);
            }
        }
        return result;
    }
}
