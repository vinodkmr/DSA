package com.ds.com.uttara.tree;

public class BinTreeNode {
	
	private int data;
	private BinTreeNode left;
	private BinTreeNode right;
	
	
	/**
	 * @param data
	 */
	public BinTreeNode(int data) {
		super();
		this.data = data;
	}
	public BinTreeNode() {
		// TODO Auto-generated constructor stub
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
	 * @return the left
	 */
	public BinTreeNode getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(BinTreeNode left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public BinTreeNode getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(BinTreeNode right) {
		this.right = right;
	}
		
}
