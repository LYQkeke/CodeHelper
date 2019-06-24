package com.keke.notebook.huawei;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by KEKE on 2019/6/24
 * 坐标移动
 */
public class Code_017 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] moves = in.nextLine().split(";");
        int x = 0;
        int y = 0;
        for (String move:moves){
            if (valid(move)){
                char direction = move.charAt(0);
                int distance = Integer.valueOf(move.substring(1,move.length()));
                if (direction=='W'){
                    y += distance;
                }else if (direction=='A'){
                    x -= distance;
                }else if (direction=='S'){
                    y -= distance;
                }else {
                    x += distance;
                }
            }
        }
        System.out.println(x+","+y);
    }

    private static boolean valid(String move){
        Pattern p = Pattern.compile("^[AWSD][0-9]{1,2}$");
        Matcher matcher = p.matcher(move);
        return matcher.find();
    }
}
