package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/4
 * 唯品会
 * 数独
 * 数独是一个非常有名的游戏。整个是一个9X9的大宫格，其中又被划分成9个3X3的小宫格。
 * 要求在每个小格中放入1-9中的某个数字。要求是：每行、每列、每个小宫格中数字不能重复。
 * 现要求用计算机求解数独。
 */
public class Code_049 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sudoku[i][j] = in.nextInt();
            }
        }
        // 找到答案就返回
        dfs(sudoku,0,0);
    }

    private static boolean dfs(int[][] sudoku, int i, int j){
        if(i==8&&j==9){
            print(sudoku);
            return true;
        }
        if(j==9){
            i++;
            j = 0;
        }


        if(sudoku[i][j]==0){
            boolean[] opts = options(sudoku,i,j);
            for(int k=1;k<10;k++){
                if(!opts[k]){
                    sudoku[i][j] = k;
                    if(dfs(sudoku,i,j+1)){
                        return true;
                    }
                    // 搜索未成功，将该位置回0值
                    sudoku[i][j] = 0;
                }
            }
        }else{
            dfs(sudoku,i,j+1);
        }
        return false;
    }

    private static boolean[] options(int[][] sudoku, int row, int col){
        boolean[] opts = new boolean[10];
        for(int i=0;i<9;i++){
            opts[sudoku[i][col]] = true;
            opts[sudoku[row][i]] = true;
        }
        row = row/3 * 3;
        col = col/3 * 3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                opts[sudoku[row+i][col+j]] = true;
            }
        }
        return opts;
    }

    private static void print(int[][] sudoku){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(j!=8)
                    System.out.print(sudoku[i][j]+" ");
                else
                    System.out.println(sudoku[i][j]);
            }
            //System.out.println();
        }
    }
}
