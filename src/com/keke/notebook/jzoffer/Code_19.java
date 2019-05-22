package com.keke.notebook.jzoffer;

import java.util.ArrayList;

/**
 * Created by KEKE on 2019/5/22
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Code_19 {
    public ArrayList<Integer> printMatrix1(int [][] matrix) {
        if(matrix==null||matrix[0].length==0)
            return null;
        ArrayList<Integer> ansList = new ArrayList<>(matrix.length*matrix[0].length);
        int col = matrix[0].length;
        int row = matrix.length;
        int start = 0;
        while(start*2<row&&start*2<col){
            printInCircle(ansList, matrix, start, row, col);
            start++;
        }
        return ansList;
    }

    private void printInCircle(ArrayList<Integer> arr, int[][] matrix, int start, int row, int col){
        int lastCol = col - 1 - start;
        int lastRow = row - 1 - start;
        for (int i = start;i<=lastCol;i++)
            arr.add(matrix[start][i]);
        if (start<lastRow){
            for (int i = start+1;i<=lastRow;i++)
                arr.add(matrix[i][lastCol]);
        }
        if (start<lastCol&&start<lastRow){
            for (int i = lastCol-1;i>=start;i--)
                arr.add(matrix[lastRow][i]);
        }
        if (start<lastRow-1&&start<lastCol){
            for (int i = lastRow-1;i>start;i--)
                arr.add(matrix[i][start]);
        }
    }

    public ArrayList<Integer> printMatrix2(int [][] matrix){
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return null;
        ArrayList<Integer> ansList = new ArrayList<>();
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int index = 0;
        while (index<=row&&index<=col){
            // 只剩一行
            if (index==row){
                for (int i=index;i<=col;i++)
                    ansList.add(matrix[index][i]);
                break;
            }
            // 只剩一列
            if (index==col&&index!=row){
                for (int i=index;i<=row;i++)
                    ansList.add(matrix[i][index]);
                break;
            }
            // 上
            for (int i = index; i < col; i++) {
                ansList.add(matrix[index][i]);
            }
            // 右
            for (int i = index; i < row; i++) {
                ansList.add(matrix[i][col]);
            }
            // 下
            for (int i = col; i > index; i--) {
                ansList.add(matrix[row][i]);
            }
            // 左
            for (int i = row; i > index; i--) {
                ansList.add(matrix[i][index]);
            }
            ++index;
            --col;
            --row;
        }
        return ansList;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2},{3,4}};
        System.out.println(new Code_19().printMatrix2(matrix));
    }
}
