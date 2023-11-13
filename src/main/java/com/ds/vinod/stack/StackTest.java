package com.ds.vinod.stack;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("traversing");
        stack.traverse();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("traversing");
        stack.traverse();
        stack.peek();

    }
}
