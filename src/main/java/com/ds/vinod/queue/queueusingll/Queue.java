package com.ds.vinod.queue.queueusingll;

public class Queue {
    private QueueNode head;
    private int size;

    public void add(int data){
        QueueNode node = new QueueNode(data);
        if(size == 0){
            head = node;
            size++;
        }else{
            QueueNode cur = head;
            while(cur.getNext() != null){
                cur = cur.getNext();
            }
            cur.setNext(node);
            size++;
        }
    }

    public int remove(){
        if(size == 0){
            System.out.println("Queue is empty");
            return -1;
        }
        QueueNode temp = head;
        head = head.getNext();
        temp.setNext(null);
        size--;
        return temp.getData();
    }

    public void traverse(){
        System.out.println("traverse");
        QueueNode temp = head;
        while(temp != null){
            System.out.print(" "+temp.getData());
            temp = temp.getNext();
        }
        System.out.println();
    }
}
