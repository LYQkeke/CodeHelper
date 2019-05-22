package com.keke.notebook.jzoffer;

import com.keke.entity.ListNode;

/**
 * Created by KEKE on 2019/5/22
 * 反转链表
 */
public class Code_15 {
    public ListNode ReverseList(ListNode head) {
        ListNode head1 = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = head1;
            head1 = head;
            head = next;
        }
        return head1;
    }
}
