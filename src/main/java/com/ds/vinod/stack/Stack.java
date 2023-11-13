package com.ds.vinod.stack;

public class Stack {
    private Node top;
    private int size;

    public int getSize() {
        return size;
    }

    public void push(int data){
        Node node = new Node(data);
        if(top == null){
            top = node;
            size++;
            return;
        }
        node.setNext(top);
        top = node;
        size++;
    }

    public int pop() {
        if (top == null) {
            System.out.println("No elements to pop");
            return 0;
        }

        Node temp = top;
        top = top.getNext();
        temp.setNext(null);
        size--;
        return temp.getData();
    }

    public void peek(){
        if (top != null){
            System.out.println(top.getData());
        }
    }

    public void traverse(){
        Node temp = top;
        while(temp != null){
            System.out.println(" "+temp.getData());
            temp = temp.getNext();
        }
        System.out.println(" ");
    }
}
