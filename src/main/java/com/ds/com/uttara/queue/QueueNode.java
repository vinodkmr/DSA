package com.ds.com.uttara.queue;

public class QueueNode {
	
	private int data;
	private QueueNode next = null;
	
	/**
	 * @param data
	 */
	public QueueNode(int data) {
		super();
		this.data = data;
	}
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
	/**
	 * @return the next
	 */
	public QueueNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(QueueNode next) {
		this.next = next;
	}
	
	

}
