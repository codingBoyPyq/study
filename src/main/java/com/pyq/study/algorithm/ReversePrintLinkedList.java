package com.pyq.study.algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by pangyueqiang on 17/8/24.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class ReversePrintLinkedList {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> data = new ArrayList<Integer>();
        if(listNode==null)
            return data;
        Stack<Integer> stack = new Stack<Integer>();
        ListNode head = listNode;
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        while(stack.size()>0){
            data.add(stack.pop());
        }
        return data;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println(printListFromTailToHead(head));
    }
}
