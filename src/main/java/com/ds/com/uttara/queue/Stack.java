package com.ds.com.uttara.queue;

public class Stack {
	
	private StackNode top = null;
	private int size;
	
	public void push(int data ) {
		StackNode newNode = new StackNode(data);
		if(null == top) {
			top = newNode;
			size++;
			return;
		}
		else {
			newNode.setNext(top);
			top = newNode;
			size++;
		}
	}
	
	public int pop() {
		int value = 0;
		StackNode temp = top;
		if(null == temp) {
			System.out.println("Stack is Empty");
		}
		else {
			top = top.getNext();
			value = temp.getData();
			temp = null;
			size--;
		}
		return value;		
	} 
	
	public int peek() {
		if(null != top)
			return top.getData();
		else
			return 0;
	}
	
	public boolean isEmpty() {
		return(null == top);
	}
	
	public int getSize() {
		return size;
	}
	public void traverse() {
		System.out.println("Traversing Stack");
		StackNode temp = top;
		while(null != temp) {
			System.out.print(" " +temp.getData());
			temp = temp.getNext();	
		}
		System.out.println();
	}

}
