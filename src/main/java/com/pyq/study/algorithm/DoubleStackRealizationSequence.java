package com.pyq.study.algorithm;

import java.util.Stack;

/**
 * Created by pangyueqiang on 17/8/24.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class DoubleStackRealizationSequence {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        DoubleStackRealizationSequence sequence = new DoubleStackRealizationSequence();
        sequence.push(1);
        sequence.push(2);
        System.out.println(sequence.pop());
        sequence.push(3);
        sequence.push(4);
        System.out.println(sequence.pop());
        System.out.println(sequence.pop());
        sequence.push(5);
        System.out.println(sequence.pop());
    }
}
