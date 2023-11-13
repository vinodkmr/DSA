package com.ds.com.uttara.tree;

public class BinaryTree_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree binTree = new BinaryTree();
		binTree.insert(1);
		binTree.insert(2);
		binTree.insert(3);
		binTree.insert(4);
		binTree.insert(5);
		binTree.insert(6);
		binTree.insert(7);
		binTree.insert(8);
		binTree.insert(9);
		binTree.insert(10);
		binTree.insert(11);
		binTree.insert(12);
		binTree.insert(13);
		binTree.insert(14);
		binTree.insert(15);
		System.out.println("Level Order Traversal");
		binTree.levelOrder();
		System.out.println();
		System.out.println("Pre Order Traversal");
		binTree.preOrder();
		System.out.println();
		System.out.println("In Order Traversal");
		binTree.inOrderTraversal();
		System.out.println();
		System.out.println("Post Order Traversal");
		binTree.postOrder();
		System.out.println();
		
		
	}

}
