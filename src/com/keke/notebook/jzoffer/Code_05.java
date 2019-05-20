package com.keke.notebook.jzoffer;

import java.util.Stack;

/**
 * Created by KEKE on 2019/5/20
 * 用两个栈实现队列
 */
public class Code_05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()&&!stack1.isEmpty())
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }
}
