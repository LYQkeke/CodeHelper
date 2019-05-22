package com.keke.notebook.jzoffer;

import java.util.Stack;

/**
 * Created by KEKE on 2019/5/22
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Code_20 {
    Stack<Integer> elementStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if(elementStack.isEmpty()){
            elementStack.push(node);
            minStack.push(node);
        }else{
            if(node<minStack.peek())
                minStack.push(node);
            else
                minStack.push(minStack.peek());
            elementStack.push(node);
        }
    }

    public void pop() {
        elementStack.pop();
        minStack.pop();
    }

    public int top() {
        return elementStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
