package com.keke.notebook.zuo.basic.class_04;

/**
 * Created by KEKE on 2019/5/9
 *
 * 折纸问题
 * --二叉树中序遍历--
 */
public class Code_05_PaperFolding {

    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    public static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        // 对于一个折痕的下一级折痕，总是上面的向下，下面的向上
        printProcess(i + 1, N, true);
        System.out.println(down ? "down " : "up ");
        printProcess(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 2;
        printAllFolds(N);
    }
}
