package com.zhu.structure;

/**
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * n [0,1000] 简单值 [-1000,1000]
 * 要求 空间复杂度 O(1) 时间复杂度 o(n)
 */
public class Merge_Two_Sorted_Linked_Lists {

    public static void main(String[] args) {

        ListNode a1 = new ListNode(-1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(5);
        ListNode a5 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        ListNode b4 = new ListNode(6);
        ListNode b5 = new ListNode(8);
        ListNode b6 = new ListNode(10);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;

        ListNode merge = recursionMerge(a1, b1);
        while (merge != null) {
            System.out.print(merge.data + "   ");
            merge = merge.next;
        }
    }

    /**
     * 哑节点（Dummy Node）
     * 思想：为了简化链表操作（特别是头节点的处理），引入一个哑节点。这个节点的作用是充当合并链表的起始节点，但不存储实际数据。
     * 优点：
     * 免去了单独处理头节点的特殊情况（如在链表为空时需要特殊处理头节点）。
     * 所有节点的添加操作都可以统一处理，减少条件判断。
     */
    public static ListNode Merge(ListNode pHead1, ListNode pHead2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (pHead1 != null && pHead2 != null) {
            if (pHead1.data <= pHead2.data) {
                tail.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                tail.next = pHead2;
                pHead2 = pHead2.next;
            }
            tail = tail.next;
        }

        if (pHead1 != null) {
            tail.next = pHead1;
        } else {
            tail.next = pHead2;
        }

        return dummy.next;
    }


    /**
     * 递归
     */
    public static ListNode recursionMerge(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return pHead1 != null ? pHead1 : pHead2;
        }
        if (pHead1.data < pHead2.data) {
            pHead1.next = recursionMerge(pHead1.next, pHead2);
            return pHead1;
        } else {
            pHead2.next = recursionMerge(pHead1, pHead2.next);
            return pHead2;
        }
    }

}
