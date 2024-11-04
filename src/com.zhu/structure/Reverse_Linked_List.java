package com.zhu.structure;

import java.util.List;

/**
 * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头
 * 数据范围 [0-1000]
 * 要求空间复杂度 O(1) 时间复杂度O(n) 一个循环
 * 空间复杂度 O(1) 算法执行过程中所需的额外空间不随输入规模的变化而变化，即算法的空间复杂度是常数级别的。
 *
 * 反转单链表
 *   递归
 *
 *
 */
public class Reverse_Linked_List {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        ListNode listNode = ReverseList(listNode1);
        while (listNode != null){
            System.out.println(listNode.data);
           listNode =  listNode.next;
        }
    }


    /**
     * 指针逆转 - 断掉当前节点向后的指针，改为向前。
     * 需要两个指针，一个当前节点的指针，一个上一个节点的指针（初始为空）
     *
     */
    public static ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            //移动两个指针
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 递归法解决
     *
     */
}


