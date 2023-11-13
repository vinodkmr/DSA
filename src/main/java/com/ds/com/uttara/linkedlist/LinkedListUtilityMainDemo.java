package com.ds.com.uttara.linkedlist;

public class LinkedListUtilityMainDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList linkedListFive = new LinkedList();
		linkedListFive.append(4);
		linkedListFive.append(8);
		linkedListFive.append(9);
		linkedListFive.append(3);
		System.out.println("Fifth LL : " );
		linkedListFive.traverse();
		
		LinkedList linkedListSix = new LinkedList();
		linkedListSix.append(8);
		linkedListSix.append(7);
		linkedListSix.append(2);
		linkedListSix.append(2);
		System.out.println("Sixth LL : " );
		linkedListSix.traverse();
		
		LinkedList sumList = LinkedListUtilityDemo.addLists(linkedListFive, linkedListSix);
		System.out.println("Sum List : ");
		sumList.traverse();

	}

}
