package com.keke.notebook.jzoffer;

import com.keke.entity.ListNode;

/**
 * Created by KEKE on 2019/5/22
 * 合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Code_16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null&&list2==null)
            return null;
        // 新建一个空节点，将新的链表直接连接到它后面
        // 可以避免一些不必要的判断
        ListNode ansList = new ListNode(0);
        ListNode cur = ansList;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1!=null){
            cur.next = list1;
        }
        if(list2!=null){
            cur.next = list2;
        }
        return ansList.next;
    }
}
