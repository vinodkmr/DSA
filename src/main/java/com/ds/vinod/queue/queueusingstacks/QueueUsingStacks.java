package com.ds.vinod.queue.queueusingstacks;

import com.ds.vinod.stack.Stack;

public class QueueUsingStacks {
    private Stack pushStack;
    private Stack popStack;

    public void enQueue(int data){
        pushStack.push(data);
    }

    public int deQueue(){
        if(pushStack.getSize() == 0 && popStack.getSize() == 0){
            System.out.println("No elements to pop");
            return 0;
        }

        if(popStack.getSize() != 0){
            popStack.pop();
            return 0;
        }

        while (pushStack.getSize() != 0){
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }
}
