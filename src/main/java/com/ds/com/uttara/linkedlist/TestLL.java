package com.ds.com.uttara.linkedlist;

public class TestLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList l = new LinkedList();
		l.append(2);
		l.append(4);
		l.append(1);
		l.append(5);
		l.append(9);
		l.append(3);
		
		l.traverse();
		
		l.delete(4);
		l.traverse();
		System.out.println("Reversing LL");
		l.reverse();
		l.traverse();
		System.out.println("Reversing LL using recursion");
		l.reverseRecursive();
		l.traverse();
	
		
		
		LinkedList llAsc = new LinkedList();
		llAsc.insertAscend(20);
		llAsc.insertAscend(30);
		llAsc.insertAscend(15);
		llAsc.insertAscend(25);
		llAsc.insertAscend(5);
		llAsc.insertAscend(35);
		llAsc.insertAscend(33);
		System.out.println("LL Ascend");
		llAsc.traverse();
		
		
		
		

	}

}
