package com.ds.com.uttara.tree;

import java.util.LinkedList;


public class BinaryTree {
	
	private BinTreeNode root = null;
	private int size;

	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}	
	
	//Insert a Node
	public void insert(int data) {
		BinTreeNode temp;
		
		BinTreeNode newNode = new BinTreeNode(data);
		newNode.setLeft(null);
		newNode.setRight(null);
		
		if(null == root) {
			root = newNode;
			size++;
			return;
		}
		else {
		LinkedList<BinTreeNode> queue = new LinkedList<BinTreeNode>();
		
		queue.addLast(root);
		while(!(queue.isEmpty())) {
			temp = queue.removeFirst();
			
			if(null != temp.getLeft()) {
				queue.addLast(temp.getLeft());
			}
			else {
					size++;
					temp.setLeft(newNode);
					return;
			}
			
			if(null != temp.getRight()) {
				queue.addLast(temp.getRight());
			}
			else {
				size++;
				temp.setRight(newNode);
				return;
			}
			
		}
	}
}
	
	
	//Level Order Traversal of the Tree
	public void levelOrder( ) {
		BinTreeNode temp = root;
		if(null == temp) {
			System.out.println("No Elements in the Tree");
			return;
		}
		else {
		LinkedList<BinTreeNode> queue = new LinkedList<BinTreeNode>();
		
		queue.addLast(temp);
		while(!(queue.isEmpty())) {
			temp = queue.removeFirst();
			System.out.print(" " +temp.getData());
			
			if(null != temp.getLeft()) {
				queue.addLast(temp.getLeft());
			}
			if(null != temp.getRight()) {
				queue.addLast(temp.getRight());
			}			
		}
	}
}
		
	//Pre Order Traversal (Recursive)
public void preOrder() {
	preOrder(root);
}
		
private void preOrder(BinTreeNode root) {
	if(null == root) 
		return;
	else{
			System.out.print(" " +root.getData());
		
			//ps.push(root, RA-L)
			preOrder(root.getLeft());
			//RA-L, root = ps.pop() 
				
			//ps.push(root, RA-R)
			preOrder(root.getRight());
			//RA-R, root = ps.pop()
		}	
	}
		
//Post Order Traversal (Recursive)
public void postOrder() {
		postOrder(root);
	}


private void postOrder(BinTreeNode root) {
	if(null == root)
		return;
	else{
			postOrder(root.getLeft());
			
			postOrder(root.getRight());
			
			System.out.print(" " +root.getData());
		}	
	}
		
//In Order Traversal (Recursive)
public void inOrderTraversal() {
	inOrder(root);
}

private void inOrder(BinTreeNode root) {
	if(null == root) 
		return;
	else{
			inOrder(root.getLeft());
			
			System.out.print(" " +root.getData());
			
			inOrder(root.getRight());	
		}		
	}
		
public boolean isTreeEmpty() {
	return (root==null);
	}
		
	
}
