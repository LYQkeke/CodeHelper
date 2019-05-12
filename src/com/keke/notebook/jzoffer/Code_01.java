package com.keke.notebook.jzoffer;

/**
 * Created by KEKE on 2019/5/12
 *
 * 二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class Code_01 {

    public boolean Find(int target, int [][] array) {
        // 从最右上的点开始（或者是左下）
        int row = 0;
        int col = array[0].length-1;
        int temp = 0;
        while (col>=0&&row<array.length){
            temp = array[row][col];
            if (temp==target)
                return true;
            else if (temp>target)
                col--;
            else
                row++;
        }
        return false;
    }

}
