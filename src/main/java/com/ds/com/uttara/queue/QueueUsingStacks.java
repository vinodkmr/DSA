package com.ds.com.uttara.queue;

public class QueueUsingStacks {
		private Stack stackOne = new Stack();
		private Stack stackTwo = new Stack();
		
		public void enQueue(int data) {
			stackOne.push(data);
		}
		
		public boolean isEmpty() {
			return (stackOne.isEmpty() && stackTwo.isEmpty());
		}
		
		public int getSize() {
			return (stackOne.getSize()+stackTwo.getSize());
		}
		public int deQueue() {
			if(!stackTwo.isEmpty()) {
				return stackTwo.pop();
			}
			else if(!stackOne.isEmpty()) {
				while (!stackOne.isEmpty())
					stackTwo.push(stackOne.pop());
				return stackTwo.pop();
			}
			else {
				System.out.println("Stack is Empty");
				return 0;
			}
		}
}
