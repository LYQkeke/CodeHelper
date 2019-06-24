package com.keke.notebook.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by KEKE on 2019/6/24
 * 密码验证合格程序
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 * 说明:长度超过2的子串
 */
public class Code_020 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String cur = in.next();
            if(cur.length()<=8){
                System.out.println("NG");
                continue;
            }
            boolean[] type = new boolean[5];
            Set<String> set = new HashSet<>();
            for(int i=0;i<cur.length();i++){
                char temp = cur.charAt(i);
                if(temp>='0'&&temp<='9'){
                    type[1] = true;
                }else if(temp>='a'&&temp<='z'){
                    type[2] = true;
                }else if(temp>='A'&&temp<='Z'){
                    type[3] = true;
                }else{
                    type[4] = true;
                }
                if (i>=2){
                    if (set.contains(cur.substring(i-2,i+1))){
                        type[0] = true;
                        break;
                    }else {
                        set.add(cur.substring(i-2,i+1));
                    }
                }
            }
            if(type[0]==true){
                System.out.println("NG");
            }else{
                int count = 0;
                for(int i=1;i<type.length;i++){
                    if(type[i]){
                        ++count;
                    }
                }
                if(count>=3){
                    System.out.println("OK");
                }else{
                    System.out.println("NG");
                }
            }
        }
    }
}
