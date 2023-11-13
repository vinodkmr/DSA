package com.ds.vinod.trees;


import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private BNode root;
    private int size;

    public BNode getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return root == null;
    }


    //inefficient insertion
    public void inEfficientInsert(int data) {
        BNode bNode = new BNode(data);
        if (isEmpty()) {
            root = bNode;
            size++;
        } else {
            Queue<BNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BNode temp = queue.remove();
                if (temp.getLeft() == null) {
                    temp.setLeft(bNode);
                    size++;
                    return;
                } else {
                    queue.add(temp.getLeft());
                }

                if (temp.getRight() == null) {
                    temp.setRight(bNode);
                    size++;
                    return;
                } else {
                    queue.add(temp.getRight());
                }
            }
        }
    }

    public void levelOrderTraversal() {
        Queue<BNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BNode temp = queue.remove();
            System.out.println(temp.getData());

            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }

            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
    }

    //LST - Left Sub Tree, RST - Right Sub Tree
    //root - LST, RST
    public void preOrderTraversal(BNode root) {
        if (root == null) return;

        System.out.println(root.getData());
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

//    In Order traversal left-root-right
    public void inOrderTraversal(BNode root) {
        if (root == null) return;

        inOrderTraversal(root.getLeft());
        System.out.println(" " + root.getData());
        inOrderTraversal(root.getRight());
    }

    public void deleteTree(BNode root) {
        delete(root);
        this.root = null;
    }

    private void delete(BNode root) {
        if (root == null) return;
        if (root.getRight() == null && root.getLeft() == null) return;

        delete(root.getLeft());
        delete(root.getRight());
        if (root.getLeft() != null) root.setLeft(null);
        if (root.getRight() != null) root.setRight(null);

    }

    //creates new node in pre-order, establishes links  in post order
    public BNode copy(BNode root){
        if(root == null) return null;
        BNode bNode = new BNode(root.getData());
        BNode left = copy(root.getLeft());
        root.setLeft(left);
        BNode right = copy(root.getRight());
        root.setRight(right);
        return bNode;
    }

    public boolean search(int data){
//        return contains(root, data);
        return containsWithRecursionSkip(root, data);
    }

    private boolean contains(BNode root, int data) {
        if(root == null) return false;
        if(root.getData() == data) return true;
        boolean left = contains(root.getLeft(), data);
        boolean right = contains(root.getRight(), data);
        return left || right;
    }

    private boolean containsWithRecursionSkip(BNode root, int data) {
        if(root == null) return false;
        if(root.getData() == data) return true;
        boolean left = contains(root.getLeft(), data);
        if(left) return left;
        boolean right = contains(root.getRight(), data);
        return right;
    }

    public boolean equals(BNode root1, BNode root2){
        if(root1 == null && root2 == null) return true; // if both are null, tree is equal
        if(root1 == null || root2 == null) return false; //This case checks, if root1 is null and root2 is not null and vice versa
        if(root1.getData() != root2.getData()) return false;
        boolean left = equals(root1.getLeft(), root2.getLeft());
        if(!left) return left;
        boolean right = equals(root1.getRight(), root2.getRight());
        return right;
    }

    public boolean areMirrors(BNode root1, BNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.getData() != root2.getData()) return false;
        boolean left = areMirrors(root1.getLeft(), root2.getRight());
        if(!left) return left;
        boolean right = areMirrors(root1.getLeft(), root2.getRight());
        return right;
    }

    /*public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.remove());
    }*/
}
