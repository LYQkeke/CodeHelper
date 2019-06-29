package com.keke.notebook.c2018;

import java.util.*;

/**
 * Created by KEKE on 2019/6/29
 * 去哪儿
 * 版本排序
 * 去哪儿前端技术团队一直很富有创新性，经常为了解决实际工作的一些痛点，自主开发一些工具，来解决这些问题。这样，工具的版本就成为了很重要的一个点，开发者如何提供正确版本，使用者如何获取正确版本，都是十分重要的。因此，版本都会遵循业界统一的规范---SemVer。常规版本规则如下：
 * (1) 版本格式：主版本号.次版本号.修订号，例如1.2.3，版本的三个位数都必须存在，并且为0到999之间的整数。
 * (2) 主版本号：当你做了不兼容的功能修改
 * (3) 次版本号：当你做了向下兼容的功能性新增
 * (4) 修订号：当你做了向下兼容的问题修正
 * 当然，使用者不一定会指定版本号，可能使用通配符（例如***）未自动获取满足条件的最新版本。
 * （在本题中，只考虑这种情况表示匹配任意版本例如2.2.*，可以匹配所有2.2.1，2.2.2等；）
 * 现在会给出一个版本列表，并给出使用者的匹配规则，找出符合版本规则而且满足条件的最新版本，并输出，如果没有找到相应结果，则输出0.
 */
public class Code_177 {

    /**
     * 测试样例输入有问题
     * 直接没有给n
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (in.hasNextLine()){
            input.add(in.nextLine());
        }
        int n = input.size();
        Map<String,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            String temp = input.get(i).trim();
            int lastDot = temp.lastIndexOf(".");
            String key = temp.substring(0,lastDot);
            int no = Integer.valueOf(temp.substring(lastDot+1));
            if (!map.containsKey(key)){
                List<Integer> list = new ArrayList<>();
                list.add(no);
                map.put(key,list);
            }else{
                map.get(key).add(no);
            }
        }
        Iterator<Map.Entry<String, List<Integer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, List<Integer>> next = iterator.next();
            List<Integer> list = next.getValue();
            Collections.sort(list);
        }
        String searchVersion = input.get(n-1).trim();
        int lastDot = searchVersion.lastIndexOf(".");
        String ver1 = searchVersion.substring(0,lastDot);
        String ver2 = searchVersion.substring(lastDot+1);
        List<Integer> list = map.get(ver1);
        if (list!=null){
            if (ver2.equals("*")){
                System.out.println(ver1+"."+list.get(list.size()-1));
                return;
            }else {
                int index = Collections.binarySearch(list,Integer.valueOf(ver2));
                if (index!=-1){
                    System.out.println(ver1+"."+list.get(index));
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
