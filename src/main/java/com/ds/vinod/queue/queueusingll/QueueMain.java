package com.ds.vinod.queue.queueusingll;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        queue.traverse();

        System.out.println("Removing");
        queue.remove();
        queue.remove();

        queue.traverse();
    }
}
