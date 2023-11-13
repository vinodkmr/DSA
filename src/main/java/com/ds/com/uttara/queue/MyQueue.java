package com.ds.com.uttara.queue;

public class MyQueue {
	
	private QueueNode front;
	private QueueNode rear;
	private int size;
	
	public void enQueue(int data) {
		
		QueueNode newNode = new QueueNode(data);
		if(isEmpty()) {
				front = rear = newNode;
				size++; return;
			}
			
		else {
			rear.setNext(newNode);
			rear = newNode;
			size++;
		}
			
	}
	
	public int deQueue() {
		
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		else {
			QueueNode temp = front;
			if(front == rear)
				front = rear = null;
			else {
				front = front.getNext();
				temp.setNext(null);
			}
		size--;
		return temp.getData();
		}
		
	}
	
	public  void traverse() {
		
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		else {
			QueueNode temp = front;
			while(temp != rear) {
				System.out.print(" "+temp.getData());
				temp = temp.getNext();
			}
			System.out.print(" "+temp.getData());
			System.out.println();
		}
		
	}
	
	public boolean isEmpty() {
		return(null == front && null == rear);
	}
	
	public int getSize() {
		return size;
	}

}
