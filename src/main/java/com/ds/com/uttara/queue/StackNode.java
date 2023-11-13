/**
 * 
 */
package com.ds.com.uttara.queue;

/**
 * @author A
 *
 */
public class StackNode {
	
	private int data;
	private StackNode next = null;
	
	
	/**
	 * @param data
	 */
	public StackNode(int data) {
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
	public StackNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(StackNode next) {
		this.next = next;
	}
	
	

}
