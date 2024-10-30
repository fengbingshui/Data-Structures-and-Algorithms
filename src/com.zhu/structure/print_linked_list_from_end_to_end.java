package com.zhu.structure;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 * 如输入{1,2,3}的链表如下图:
 * 返回一个数组为[3,2,1]
 * 0 <= 链表长度 <= 10000
 *      从后往前打印结果
 *      栈
 *      递归
 */
public class print_linked_list_from_end_to_end {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        ArrayList<Integer> list = printListFromTailToHead2(listNode1);
        System.out.println(list);
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        Stack<Integer> s = new Stack<Integer>();
        while (listNode != null){
            Integer data = listNode.getData();
            s.push(data);
            listNode = listNode.getNext();
        }

        while (!s.isEmpty()){
            resultList.add(s.pop());
        }
        return resultList;
    }


    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        recursion(listNode,resultList);
        return resultList;
    }
    /**
     * 递归三要素
     * 终止条件： 递归进入链表尾，即节点为空节点时结束递归。<br>
     * 返回值： 每次返回子问题之后的全部输出。<br>
     * 本级任务： 每级子任务递归地进入下一级，等下一级的子问题输出数组返回时，将自己的节点值添加在数组末尾。- 根据归步骤获取值
     */
    public static void recursion(ListNode head,ArrayList<Integer> list){
        if(head != null){
            recursion(head.getNext(), list);
            list.add(head.getData());
        }
    }
}
