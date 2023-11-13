package com.ds.com.uttara.linkedlist;

import java.util.Stack;

public class LinkedList {
	
	private int size;
	private Node head;
	
	
	public LinkedList() {
		
	}
	
	public LinkedList(Node head) {
		super();
		this.head = head;
	}
	
	public Node getHead() {
		return head;
	}


	void append(int data) {
		//create new node
		Node n= new Node(data);
		
		//check is first node
		if(null == head) {
			head = n;
			size++;
			return;
		}
		else {
			Node temp = head;
			while(temp.getNext() != null){
				 temp = temp.getNext();
			}
			temp.setNext(n);
			size++;	
			
		}	
	}
	
	
	void traverse() {
		Node temp = head;
		while(temp!= null) {
			System.out.print("  " +temp.getData());
			temp = temp.getNext();
		}
		System.out.println();
		
	}
	
	void delete(int data) {
		// list is empty(null==head)
		if(null==head) {
			System.out.println("LL is empty");
			return;	
		}
		// if node to be deleted is first node
		else if(data == head.getData()) {
			Node temp = head;
			head = head.getNext();
			temp.setNext(null);
			size--; return;	
		}
		else {
			//delete any other node
			// delete last node
			Node prev = head;
			Node cur = head.getNext();

			while(cur!= null) {
				if(data == cur.getData()) {
					prev.setNext(cur.getNext());
					cur.setNext(null);
					size--; 
					return;

				}else {
					//traversing...
					prev=cur;
					cur = cur.getNext();	
				}

			}
			// data does not  exist.
			if(cur==null) {
				System.out.println("Data doesn't Exist");
			}
		}	

	}
	
	public int getSize() {
		return size;
	}
	
	
public	int getMiddle() {

		Node fast =  head;
		Node slow = head;

		while (fast !=null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();	
		}

		return slow.getData();
	}
	
	boolean isEmpty() {
		return (head == null);
	}
	
	public void reverse() {
		// Set prev node with null and current with head
		Node prev = null;
		Node current = head;
		while (current != null) {
			// set temp node to current.next
			Node temp = current.getNext();
			// Point current.next to prev
			current.setNext(prev);
			// move prev and current by one
			prev = current;
			current = temp;
		}
		// set head node with prev
		head = prev;
	}
	

	
	
	
	
	
	
	
	
	
	
	public void reverseRecursive() {
		Node prev = null;
		reverseRec(prev, head);
	}

	private void reverseRec(Node prev, Node current) {
		if (null == current) {
			head = prev;
			return;
		} else {
			Node temp = current.getNext();
			current.setNext(prev);
			reverseRec(current, temp);
		}
	}

		
	void insertAscend(int data) {
		//create new node with data
		Node n = new Node(data);
		
		//List is empty or data is smallest
		if(isEmpty() || data < head.getData()) {
			n.setNext(head);
			head = n;
			size++;
			return;
		}
		else {
		//Any where other than first
		Node prev = head;
		Node cur = head.getNext();
		while(cur != null) {
			if(cur.getData() < data) {
				prev = cur;
				cur = cur.getNext();
			}
			else {
				n.setNext(cur);
				prev.setNext(n);
				size++;return;
			}
		}
		prev.setNext(n);
		size++;
		
		}

	}
	

	
	
	
	
	
	
	
	
	
	

}
