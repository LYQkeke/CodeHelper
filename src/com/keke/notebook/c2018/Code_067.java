package com.keke.notebook.c2018;

import java.util.Scanner;

/**
 * Created by KEKE on 2019/6/11
 * 搜狐畅游
 * 数据分页说明
 * 数据分页,对于指定的页数和每页的元素个数，返回该页应该显示的数据。
 */
public class Code_067 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for(int i=0;i<n;i++){
            data[i] = in.nextInt();
        }
        int page = in.nextInt();
        int size = in.nextInt();
        int total = (n-1)/size + 1;
        if(page>total){
            System.out.println("超出分页范围");
            return;
        }
        int start = page*size;
        int end = start+size>=n?n:start+size;
        for(int i=start;i<end;i++){
            System.out.println(data[i]);
        }
    }
}
