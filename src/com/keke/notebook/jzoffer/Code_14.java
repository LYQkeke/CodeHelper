package com.keke.notebook.jzoffer;

import com.keke.entity.ListNode;

/**
 * Created by KEKE on 2019/5/22
 * 链表中倒数第k个节点
 * 双指针
 * 注意处理特殊情况
 */
public class Code_14 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null||k<1)
            return null;
        ListNode tail = head;
        ListNode kth = head;
        while(--k>0){
            tail = tail.next;
            if(tail==null)
                return null;
        }
        while(tail.next!=null){
            tail = tail.next;
            kth = kth.next;
        }
        return kth;
    }

}
