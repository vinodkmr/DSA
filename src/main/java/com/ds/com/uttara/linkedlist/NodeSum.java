package com.ds.com.uttara.linkedlist;

public class NodeSum {
	private Node DataNode;
	private int carry;
	
	public NodeSum(Node dataNode, int carry) {
		super();
		DataNode = dataNode;
		this.carry = carry;
	}

	public Node getDataNode() {
		return DataNode;
	}

	public void setDataNode(Node dataNode) {
		DataNode = dataNode;
	}

	public int getCarry() {
		return carry;
	}

	public void setCarry(int carry) {
		this.carry = carry;
	}
	
	
}
