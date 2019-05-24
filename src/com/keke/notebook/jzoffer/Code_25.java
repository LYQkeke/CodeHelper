package com.keke.notebook.jzoffer;

import com.keke.entity.RandomListNode;

/**
 * Created by KEKE on 2019/5/24
 * 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * hashmap 、复制节点
 */
public class Code_25 {
    public RandomListNode Clone(RandomListNode head)
    {
        if(head==null)
            return null;
        RandomListNode cur = head;
        RandomListNode next = null;
        RandomListNode head1 = null;
        // 在每一个节点后面，新建一个节点，复制节点的label
        while(cur!=null){
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        // 复制节点的随机指针
        cur = head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 恢复连接
        head1 = head.next;
        cur = head;
        while(cur!=null){
            next = cur.next.next;
            if(next!=null){
                cur.next.next = next.next;
            }else{
                cur.next.next = null;
            }
            cur.next = next;
            cur = cur.next;
        }
        return head1;
    }
}
