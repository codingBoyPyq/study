package com.pyq.study.algorithm.linkedList;

public class SortLinkedListUtils {

    public static void sort(SinglyListNode head){

    }

    public void swap(SinglyListNode node1 ,SinglyListNode node2){
        node1.val = node1.val ^ node2.val;
        node2.val = node1.val ^ node2.val;
        node1.val = node1.val ^ node2.val;
    }
}
