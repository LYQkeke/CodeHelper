package com.keke.notebook.jzoffer;

import com.keke.entity.ListNode;

import java.util.ArrayList;

/**
 * Created by KEKE on 2019/5/20
 * 从尾到头打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Code_03 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode==null)
            return new ArrayList<Integer>();
        ListNode cur = listNode;
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 先给list中添加元素
        while (cur!=null){
            arrayList.add(0);
            cur = cur.next;
        }
        cur = listNode;
        int index = arrayList.size()-1;
        // 从尾到头重新设置list中的元素
        while (cur!=null){
            arrayList.set(index--, cur.val);
            cur = cur.next;
        }
        return arrayList;
    }
}
