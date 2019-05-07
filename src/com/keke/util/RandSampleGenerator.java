package com.keke.util;

/**
 * 随机样本生成
 * Created by KEKE on 2019/5/7
 */
public class RandSampleGenerator {

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
}
