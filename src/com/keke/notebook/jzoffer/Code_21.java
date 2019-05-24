package com.keke.notebook.jzoffer;

import java.util.Stack;

/**
 * Created by KEKE on 2019/5/22
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Code_21 {
    /**
     * 模拟出入栈
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length!=pushA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        for(int i=0;i<popA.length;i++){
            while(stack.isEmpty()||stack.peek()!=popA[i]){
                if(pushIndex>=pushA.length)
                    return false;
                stack.push(pushA[pushIndex++]);
            }
            if(stack.peek()!=popA[i])
                return false;
            else
                stack.pop();
        }
        return true;
    }
}
