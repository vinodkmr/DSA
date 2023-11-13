package com.ds.com.uttara.linkedlist;

public class LinkedListUtilityDemo extends LinkedList {

	public static LinkedList addLists(LinkedList l1, LinkedList l2) {
		
		NodeSum sum = addListsHelper(l1.getHead(), l2.getHead());
		if(sum.getCarry() != 0) {
			Node newN = new Node(sum.getCarry());
			newN.setNext(sum.getDataNode());
			return new LinkedList(newN);
		}
		else {
		
		return new  LinkedList(sum.getDataNode());
		}
	}

	private static NodeSum addListsHelper(Node l1, Node l2) {
		if(l1==null && l2==null) {
			return new NodeSum(null, 0);
		}
		else {
			NodeSum fsum = addListsHelper(l1.getNext(), l2.getNext());
			
			int val = l1.getData()+l2.getData()+fsum.getCarry();
			Node newN = new Node(val%10);
			
			newN.setNext(fsum.getDataNode());
			
			//update fsum
			fsum.setCarry(val/10);
			fsum.setDataNode(newN);
			
			return fsum;
		}
		

	}	



}
